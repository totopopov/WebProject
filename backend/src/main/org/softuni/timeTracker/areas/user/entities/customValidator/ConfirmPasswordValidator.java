package org.softuni.timeTracker.areas.user.entities.customValidator;


import org.softuni.timeTracker.areas.user.model.RegisterUserBindingModel;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ConfirmPasswordValidator implements ConstraintValidator<ConfirmPassword, RegisterUserBindingModel> {

    @Override
    public boolean isValid(RegisterUserBindingModel user, ConstraintValidatorContext constraintValidatorContext) {
        return user.getPassword().equals(user.getConfirmPassword());
    }
}

