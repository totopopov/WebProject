package org.softuni.timeTracker.areas.user.controller;

import com.google.gson.Gson;
import org.softuni.timeTracker.annotations.GetIP;
import org.softuni.timeTracker.areas.user.models.RegisterUserBindingModel;
import org.softuni.timeTracker.areas.user.service.UserService;
import org.softuni.timeTracker.constants.Const;
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

    private final UserService userService;
    private final Gson gson;

    @Autowired
    public AccountController(UserService userService, Gson gson) {
        this.userService = userService;
        this.gson = gson;
    }

    @GetIP
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
                .body(gson.toJson(Const.SERVER_ERROR_TRY_AGAIN));
    }

    @GetMapping(value = "/api/get-role", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getCurrentRoles() {

        List<String> authorities = this.userService
                .loadUserByUsername(SecurityContextHolder.getContext().getAuthentication().
                        getPrincipal().toString()).getAuthorities().
                        stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList());

        return ResponseEntity.ok(gson.toJson(authorities));
    }
}
