package org.softuni.timeTracker.areas.user.entities.customValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Constraint(validatedBy = ConfirmPasswordValidator.class)
public @interface ConfirmPassword {

    String PASSWORD_MISSMATCHING = "Password missmatching";

    String message() default PASSWORD_MISSMATCHING;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
