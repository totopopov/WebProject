package org.softuni.timeTracker.areas.time.entities.customValidator;


import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class ConfirmTimeUnitTimeValidatorValidator implements ConstraintValidator<ConfirmTImeUnitTime, Double> {


    @Override
    public boolean isValid(Double time, ConstraintValidatorContext context) {
        return time > 0.5 && time < 8 && ((int) (time / 0.5)) == (time / 0.5);
    }
}