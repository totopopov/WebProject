package org.softuni.timeTracker.areas.time.controller;

import com.google.gson.Gson;
import org.softuni.timeTracker.areas.time.models.activity.ActivityTransferModel;
import org.softuni.timeTracker.areas.time.models.activity.RegisterActivityBindingModel;
import org.softuni.timeTracker.areas.time.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Todor Popov using Lenovo on 26.4.2018 г. at 22:31.
 */

@RestController
@RequestMapping("/admin")
public class AdminActivityController {

    private final ActivityService activityService;
    private final Gson gson;

    @Autowired
    public AdminActivityController(ActivityService activityService, Gson gson) {
        this.activityService = activityService;
        this.gson = gson;
    }


    @GetMapping(value = "/activities", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getUsers() {

        List<ActivityTransferModel> allActivities = this.activityService.getAllActivities();

        return ResponseEntity.ok(gson.toJson(allActivities));
    }

    @PostMapping(value = "/activity/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createActivity(@RequestBody @Valid RegisterActivityBindingModel activity, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            ActivityTransferModel registerActivityBindingModel = this.activityService.saveActivity(activity);
            return ResponseEntity.ok(gson.toJson(registerActivityBindingModel));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(gson.toJson(bindingResult.getAllErrors().get(0).getDefaultMessage()));
        }
    }

    @GetMapping(value = "/activity/activate/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity activate(@PathVariable String id) {

        return ResponseEntity.ok(gson.toJson(this.activityService.enable(id, Boolean.TRUE)));
    }

    @GetMapping(value = "/activity/deactivate/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deactivate(@PathVariable String id) {
        return ResponseEntity.ok(gson.toJson(this.activityService.enable(id, Boolean.FALSE)));
    }


}
