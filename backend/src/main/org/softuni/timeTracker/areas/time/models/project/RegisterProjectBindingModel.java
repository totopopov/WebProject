package org.softuni.timeTracker.areas.time.models.project;

import org.softuni.timeTracker.areas.time.entities.customValidator.ConfirmProjectName;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class RegisterProjectBindingModel {

    public static final String DESCRIPTION_MUST_BE_BETWEEN_3_AND_30_CHARACHTERS = "Description must be between 3 and 30 charachters";
    public static final String PROJECT_NAME_MUST_BE_BETWEEN_3_AND_20_CHARACHTERS = "Project name must be between 3 and 20 charachters";
    public static final String PROJECT_NAME_CANNOT_BE_EMPTY = "Project name cannot be empty";
    public static final String DESCRIPTION_CANNOT_BE_EMPTY = "Description cannot be empty";


    @NotNull(message = PROJECT_NAME_CANNOT_BE_EMPTY)
    @ConfirmProjectName
    @Pattern(regexp = "(.){3,20}", message = PROJECT_NAME_MUST_BE_BETWEEN_3_AND_20_CHARACHTERS)
    private String project;

    @NotNull(message = DESCRIPTION_CANNOT_BE_EMPTY)
    @Pattern(regexp = "(.){3,30}", message = DESCRIPTION_MUST_BE_BETWEEN_3_AND_30_CHARACHTERS)
    private String description;


    public RegisterProjectBindingModel() {

    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getEnabled() {
        return Boolean.TRUE;
    }
}
