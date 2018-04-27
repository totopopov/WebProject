package org.softuni.timeTracker.areas.time.entities.customValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Constraint(validatedBy = ConfirmDateValidator.class)
public @interface ConfirmDate {

    String PASSWORD_MISSMATCHING = "Future Date given.";

    String message() default PASSWORD_MISSMATCHING;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
