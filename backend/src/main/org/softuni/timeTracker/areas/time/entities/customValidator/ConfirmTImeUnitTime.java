package org.softuni.timeTracker.areas.time.entities.customValidator;

import org.springframework.stereotype.Component;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Component
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ConfirmTimeUnitTimeValidatorValidator.class)
public @interface ConfirmTImeUnitTime {

    String TRY_ANOTHER = "Time should be between 0.5 and 8 with a step of 0.5";

    String message() default TRY_ANOTHER;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
