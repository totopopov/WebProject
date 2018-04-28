package org.softuni.timeTracker.areas.time.controller;


import com.google.gson.Gson;
import org.softuni.timeTracker.areas.time.models.timeUnit.RegisterTimeUnitBindingModel;
import org.softuni.timeTracker.areas.time.models.timeUnit.TimeUnitSimpleTransferModel;
import org.softuni.timeTracker.areas.time.service.TimeUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Todor Popov using Lenovo on 28.4.2018 г. at 5:50.
 */

@RestController
public class TimeUnitController {


    private final TimeUnitService timeUnitService;
    private final Gson gson;

    @Autowired
    public TimeUnitController(TimeUnitService timeUnitService, Gson gson) {
        this.timeUnitService = timeUnitService;
        this.gson = gson;
    }

    @PostMapping(value = "/entry/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity register(@RequestBody @Valid RegisterTimeUnitBindingModel entry, BindingResult bindingResult) {

        if (!bindingResult.hasErrors()) {
            TimeUnitSimpleTransferModel timeUnitSimpleTransferModel = this.timeUnitService.registerEntry(entry);
            return ResponseEntity.ok(gson.toJson(timeUnitSimpleTransferModel));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(gson.toJson(bindingResult.getAllErrors().get(0).getDefaultMessage()));
        }
    }

    @GetMapping(value = "/entries", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllEtnries() {

        List<TimeUnitSimpleTransferModel> allEntries = this.timeUnitService.getAllEntries();

        return ResponseEntity.ok(gson.toJson(allEntries));

    }
}
