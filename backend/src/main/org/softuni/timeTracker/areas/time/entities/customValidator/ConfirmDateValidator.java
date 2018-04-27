package org.softuni.timeTracker.areas.time.entities.customValidator;


import org.softuni.timeTracker.areas.user.models.RegisterUserBindingModel;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ConfirmDateValidator implements ConstraintValidator<ConfirmDate, RegisterUserBindingModel> {

    @Override
    public boolean isValid(RegisterUserBindingModel user, ConstraintValidatorContext constraintValidatorContext) {
        return user.getPassword().equals(user.getConfirmPassword());
    }
}

