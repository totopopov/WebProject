package org.softuni.timeTracker.areas.time.customValidator;


import org.softuni.timeTracker.areas.user.model.RegisterUserBindingModel;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ConfirmDateValidator implements ConstraintValidator<ConfirmDate, RegisterUserBindingModel> {

    @Override
    public boolean isValid(RegisterUserBindingModel user, ConstraintValidatorContext constraintValidatorContext) {
        return user.getPassword().equals(user.getConfirmPassword());
    }
}

