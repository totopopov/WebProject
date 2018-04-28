package org.softuni.timeTracker.areas.time.controller;

import com.google.gson.Gson;
import org.softuni.timeTracker.areas.time.models.project.ProjectSimpleTransferModel;
import org.softuni.timeTracker.areas.time.models.project.RegisterProjectBindingModel;
import org.softuni.timeTracker.areas.time.service.ProjectService;
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
public class AdminProjectController {

    private final ProjectService projectService;
    private final Gson gson;

    @Autowired
    public AdminProjectController(ProjectService projectService, Gson gson) {
        this.projectService = projectService;
        this.gson = gson;
    }


    @GetMapping(value = "/projects", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getUsers() {

        List<ProjectSimpleTransferModel> allProjects = this.projectService.getAllProjects();

        return ResponseEntity.ok(gson.toJson(allProjects));
    }

    @PostMapping(value = "/project/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createActivity(@RequestBody @Valid RegisterProjectBindingModel project, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            ProjectSimpleTransferModel registerActivityBindingModel = this.projectService.saveProject(project);
            return ResponseEntity.ok(gson.toJson(registerActivityBindingModel));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(gson.toJson(bindingResult.getAllErrors().get(0).getDefaultMessage()));
        }
    }

    @GetMapping(value = "/project/activate/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity activate(@PathVariable String id) {

        return ResponseEntity.ok(gson.toJson(this.projectService.enable(id, Boolean.TRUE)));
    }

    @GetMapping(value = "/project/deactivate/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deactivate(@PathVariable String id) {
        return ResponseEntity.ok(gson.toJson(this.projectService.enable(id, Boolean.FALSE)));
    }

    @GetMapping(value = "/project/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity edit(@PathVariable String id) {
        return ResponseEntity.ok(gson.toJson(this.projectService.findById(id)));
    }

    @GetMapping(value = "/project/add/{id}/{activityId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity editAdd(@PathVariable String id, @PathVariable String activityId) {
        return ResponseEntity.ok(gson.toJson(this.projectService.addActivities(id, activityId)));
    }

    @GetMapping(value = "/project/remove/{id}/{activityId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity editRemove(@PathVariable String id, @PathVariable String activityId) {
        return ResponseEntity.ok(gson.toJson(this.projectService.removeActivities(id, activityId)));
    }


}
