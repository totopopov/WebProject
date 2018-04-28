package org.softuni.timeTracker.areas.time.entities.customValidator;


import org.softuni.timeTracker.areas.time.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class ConfirmProjectNameValidator implements ConstraintValidator<ConfirmProjectName, String> {
    private final ProjectService projectService;

    @Autowired
    public ConfirmProjectNameValidator(ProjectService projectService) {
        this.projectService = projectService;
    }

    @Override
    public void initialize(ConfirmProjectName constraintAnnotation) {
    }

    @Override
    public boolean isValid(String project, ConstraintValidatorContext context) {
        return this.projectService.checkDoesNotExist(project);
    }
}