package org.softuni.timeTracker.areas.time.models.project;

import java.util.List;

public class ProjectTransferModel {

    private String id;

    private String project;

    private String description;

    private List<String> simpleActivities;


    public ProjectTransferModel() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public List<String> getSimpleActivities() {
        return simpleActivities;
    }

    public void setSimpleActivities(List<String> simpleActivities) {
        this.simpleActivities = simpleActivities;
    }
}
