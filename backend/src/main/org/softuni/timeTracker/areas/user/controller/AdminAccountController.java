package org.softuni.timeTracker.areas.user.controller;

import com.google.gson.Gson;
import org.softuni.timeTracker.areas.user.models.EditUserBindingModel;
import org.softuni.timeTracker.areas.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Todor Popov using Lenovo on 26.4.2018 г. at 22:31.
 */

@RestController
@RequestMapping("/admin")
public class AdminAccountController {

    private final UserService userService;
    private final Gson gson;

    @Autowired
    public AdminAccountController(UserService userService, Gson gson) {
        this.userService = userService;
        this.gson = gson;
    }


    @GetMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getUsers() {

        List<EditUserBindingModel> allUsers = this.userService.getAllUsers();

        return ResponseEntity.ok(gson.toJson(allUsers));
    }

    @GetMapping(value = "/promote/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity promote(@PathVariable String name) {

        return ResponseEntity.ok(gson.toJson(this.userService.promote(name)));
    }

    @GetMapping(value = "/demote/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity demote(@PathVariable String name) {

        return ResponseEntity.ok(gson.toJson(this.userService.demote(name)));
    }

    @GetMapping(value = "/deactivate/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deactivate(@PathVariable String name) {

        return ResponseEntity.ok(gson.toJson(this.userService.enable(name, Boolean.FALSE)));
    }

    @GetMapping(value = "/activate/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity activate(@PathVariable String name) {
        return ResponseEntity.ok(gson.toJson(this.userService.enable(name, Boolean.TRUE)));
    }
}
