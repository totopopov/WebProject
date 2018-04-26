package org.softuni.timeTracker.areas.user.controller;

import com.google.gson.Gson;
import org.softuni.timeTracker.areas.user.model.EditUserBindingModel;
import org.softuni.timeTracker.areas.user.model.RegisterUserBindingModel;
import org.softuni.timeTracker.areas.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class AccountController {


    private static final String SUCCESSFULLY_REGISTERED_USER = "Successfully registered user.";
    private static final String SERVER_ERROR_TRY_AGAIN = "Server error ! Try again.";
    private final UserService userService;
    private final Gson gson;

    @Autowired
    public AccountController(UserService userService, Gson gson) {
        this.userService = userService;
        this.gson = gson;
    }

    @PostMapping(value = "/register", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity register(@RequestBody @Valid RegisterUserBindingModel user, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            if (this.userService.save(user)) {
                return ResponseEntity.ok(gson.toJson(SUCCESSFULLY_REGISTERED_USER));
            }

        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(gson.toJson(bindingResult.getAllErrors().get(0).getDefaultMessage()));
        }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(gson.toJson(SERVER_ERROR_TRY_AGAIN));
    }

    @GetMapping(value = "/api/get-role", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getCurrentRoles() {

        List<String> authorities = this.userService
                .loadUserByUsername(SecurityContextHolder.getContext().getAuthentication().
                        getPrincipal().toString()).getAuthorities().
                        stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList());

        return ResponseEntity.ok(gson.toJson(authorities));
    }


    @GetMapping(value = "/admin/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getUsers() {

        List<EditUserBindingModel> allUsers = this.userService.getAllUsers(SecurityContextHolder.getContext().getAuthentication().
                getPrincipal().toString());

        return ResponseEntity.ok(gson.toJson(allUsers));
    }

    @GetMapping(value = "/admin/promote/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity promote(@PathVariable String name) {

        EditUserBindingModel user = this.userService.promote(name);

        return ResponseEntity.ok(gson.toJson(user));
    }

    @GetMapping(value = "/admin/demote/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity demote(@PathVariable String name) {

        EditUserBindingModel user = this.userService.promote(name);

        return ResponseEntity.ok(gson.toJson(user));
    }


}
