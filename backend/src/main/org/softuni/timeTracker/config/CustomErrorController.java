package org.softuni.timeTracker.config;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Todor Popov using Lenovo on 27.4.2018 г. at 21:25.
 */

@RestController
public class CustomErrorController implements ErrorController {

    private final Gson gson;

    @Autowired
    public CustomErrorController(Gson gson) {
        this.gson = gson;
    }

    @RequestMapping("/error")
    public ResponseEntity handleError(HttpServletRequest request) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        return ResponseEntity.ok(gson.toJson(status));

    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}

