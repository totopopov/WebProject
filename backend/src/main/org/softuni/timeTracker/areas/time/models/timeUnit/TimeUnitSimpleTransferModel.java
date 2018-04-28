package org.softuni.timeTracker.areas.time.models.timeUnit;

/**
 * Created by Todor Popov using Lenovo on 28.4.2018 г. at 8:07.
 */


public class TimeUnitSimpleTransferModel {

    private String dateFormated;

    private Double time;

    private Integer taskCompleted;

    private String comments;

    private String simpleProject;

    private String simpleActivity;

    public TimeUnitSimpleTransferModel() {
    }

    public String getDateFormated() {
        return dateFormated;
    }

    public void setDateFormated(String dateFormated) {
        this.dateFormated = dateFormated;
    }

    public Double getTime() {
        return time;
    }

    public void setTime(Double time) {
        this.time = time;
    }

    public Integer getTaskCompleted() {
        return taskCompleted;
    }

    public void setTaskCompleted(Integer taskCompleted) {
        this.taskCompleted = taskCompleted;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getSimpleProject() {
        return simpleProject;
    }

    public void setSimpleProject(String simpleProject) {
        this.simpleProject = simpleProject;
    }

    public String getSimpleActivity() {
        return simpleActivity;
    }

    public void setSimpleActivity(String simpleActivity) {
        this.simpleActivity = simpleActivity;
    }
}
