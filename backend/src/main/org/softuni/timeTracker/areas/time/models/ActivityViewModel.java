package org.softuni.timeTracker.areas.time.models;


public class ActivityViewModel {

    private String id;

    private String activity;

    private String activityKPI;

    private String description;

    private Boolean enabled;

    public ActivityViewModel() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}
