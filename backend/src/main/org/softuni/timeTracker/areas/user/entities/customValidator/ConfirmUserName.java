package org.softuni.timeTracker.areas.user.entities.customValidator;

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
@Constraint(validatedBy = ConfirmUserNameValidator.class)
public @interface ConfirmUserName {

    String USERNAME_EXITS_TRY_ANOTHER = "Username exits. Try another !";

    String message() default USERNAME_EXITS_TRY_ANOTHER;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
