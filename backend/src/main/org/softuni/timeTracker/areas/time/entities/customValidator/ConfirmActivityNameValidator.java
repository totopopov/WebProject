package org.softuni.timeTracker.areas.time.entities.customValidator;


import org.softuni.timeTracker.areas.time.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class ConfirmActivityNameValidator implements ConstraintValidator<ConfirmActivityName, String> {
    private final ActivityService activityService;

    @Autowired
    public ConfirmActivityNameValidator(ActivityService activityService) {
        this.activityService = activityService;
    }

    @Override
    public void initialize(ConfirmActivityName constraintAnnotation) {
    }

    @Override
    public boolean isValid(String activity, ConstraintValidatorContext context) {
        return this.activityService.CheckDoesNotExist(activity);
    }
}