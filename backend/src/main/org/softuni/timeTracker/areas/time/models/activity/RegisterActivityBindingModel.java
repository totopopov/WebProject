package org.softuni.timeTracker.areas.time.models.activity;


import org.softuni.timeTracker.areas.time.entities.customValidator.ConfirmActivityName;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class RegisterActivityBindingModel {

    public static final String ACTIVITY_NAME_MUST_BE_BETWEEN_3_AND_20_CHARACHTERS = "Activity name must be between 3 and 20 charachters";
    public static final String ACTIVITY_KPI_MUST_BE_BETWEEN_5_AND_20_CHARACHTERS = "Activity KPI must be between 5 and 20 charachters";
    public static final String ACTIVITY_KPI_MUST_BE_BETWEEN_3_AND_35_CHARACHTERS = "Activity KPI must be between 3 and 35 charachters";
    public static final String DESCRIPTION_CAN_NOT_BE_EMPTY = "Description can not be empty";
    public static final String ACTIVITY_KPI_CAN_NOT_BE_EMPTY = "Activity KPI can not be empty";
    public static final String ACTIVITY_CAN_NOT_BE_EMPTY = "Activity can not be empty";
    @ConfirmActivityName
    @NotNull(message = ACTIVITY_CAN_NOT_BE_EMPTY)
    @Pattern(regexp = "(.){3,20}", message = ACTIVITY_NAME_MUST_BE_BETWEEN_3_AND_20_CHARACHTERS)
    private String activity;

    @NotNull(message = ACTIVITY_KPI_CAN_NOT_BE_EMPTY)
    @Pattern(regexp = "(.){5,20}", message = ACTIVITY_KPI_MUST_BE_BETWEEN_5_AND_20_CHARACHTERS)
    private String activityKPI;

    @NotNull(message = DESCRIPTION_CAN_NOT_BE_EMPTY)
    @Pattern(regexp = "(.){3,35}", message = ACTIVITY_KPI_MUST_BE_BETWEEN_3_AND_35_CHARACHTERS)
    private String description;


    public RegisterActivityBindingModel() {
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getActivityKPI() {
        return activityKPI;
    }

    public void setActivityKPI(String activityKPI) {
        this.activityKPI = activityKPI;
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
