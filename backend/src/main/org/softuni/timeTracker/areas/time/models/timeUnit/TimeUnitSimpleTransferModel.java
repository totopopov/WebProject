package org.softuni.timeTracker.areas.time.models.timeUnit;

import java.util.Date;

/**
 * Created by Todor Popov using Lenovo on 28.4.2018 г. at 8:07.
 */


public class TimeUnitSimpleTransferModel {


    private Date date;

    private Double time;

    private Integer taskCompleted;

    private String comments;

    private String SimpleProject;

    private String SimpleActiivy;

    public TimeUnitSimpleTransferModel() {
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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
        return SimpleProject;
    }

    public void setSimpleProject(String simpleProject) {
        SimpleProject = simpleProject;
    }

    public String getSimpleActiivy() {
        return SimpleActiivy;
    }

    public void setSimpleActiivy(String simpleActiivy) {
        SimpleActiivy = simpleActiivy;
    }
}