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
@Constraint(validatedBy = ConfirmProjectNameValidator.class)
public @interface ConfirmProjectName {

    String TRY_ANOTHER = "Project name exits. Try another !";

    String message() default TRY_ANOTHER;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
