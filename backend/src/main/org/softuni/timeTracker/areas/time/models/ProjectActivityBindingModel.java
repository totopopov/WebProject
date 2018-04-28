package org.softuni.timeTracker.areas.time.models;

import org.softuni.timeTracker.areas.time.models.activity.ActivityTransferModel;
import org.softuni.timeTracker.areas.time.models.project.ProjectTransferModel;

/**
 * Created by Todor Popov using Lenovo on 28.4.2018 г. at 5:07.
 */
public class ProjectActivityBindingModel {
    private ProjectTransferModel projectTransferModel;
    private ActivityTransferModel activityTransferModel;

    public ProjectActivityBindingModel() {
    }

    public ProjectActivityBindingModel(ProjectTransferModel projectTransferModel, ActivityTransferModel activityTransferModel) {
        this.projectTransferModel = projectTransferModel;
        this.activityTransferModel = activityTransferModel;
    }

    public ProjectTransferModel getProjectTransferModel() {
        return projectTransferModel;
    }

    public void setProjectTransferModel(ProjectTransferModel projectTransferModel) {
        this.projectTransferModel = projectTransferModel;
    }

    public ActivityTransferModel getActivityTransferModel() {
        return activityTransferModel;
    }

    public void setActivityTransferModel(ActivityTransferModel activityTransferModel) {
        this.activityTransferModel = activityTransferModel;
    }
}
