package org.softuni.timeTracker.areas.user.entities.customValidator;


import org.softuni.timeTracker.areas.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class ConfirmUserNameValidator implements ConstraintValidator<ConfirmUserName, String> {
    private final UserService userService;

    @Autowired
    public ConfirmUserNameValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void initialize(ConfirmUserName constraintAnnotation) {
    }

    @Override
    public boolean isValid(String username, ConstraintValidatorContext context) {
        return !userService.userExists(username);
    }

}