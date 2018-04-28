package org.softuni.timeTracker.areas.time.controller;


import com.google.gson.Gson;
import org.softuni.timeTracker.areas.time.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Todor Popov using Lenovo on 28.4.2018 г. at 5:50.
 */

@RestController
public class ProjectController {


    private final ProjectService projectService;
    private final Gson gson;

    @Autowired
    public ProjectController(ProjectService projectService, Gson gson) {
        this.projectService = projectService;
        this.gson = gson;
    }

    @GetMapping(value = "/projects", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getUsers() {

        return ResponseEntity.ok(gson.toJson(this.projectService.getAllActiveProjects()));
    }
}
