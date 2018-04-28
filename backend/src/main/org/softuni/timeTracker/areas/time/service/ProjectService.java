package org.softuni.timeTracker.areas.time.service;

import org.softuni.timeTracker.areas.time.models.ProjectActivityBindingModel;
import org.softuni.timeTracker.areas.time.models.project.ProjectSimpleTransferModel;
import org.softuni.timeTracker.areas.time.models.project.ProjectTransferModel;
import org.softuni.timeTracker.areas.time.models.project.RegisterProjectBindingModel;

import java.util.List;

/**
 * Created by Todor Popov using Lenovo on 27.4.2018 г. at 14:06.
 */
public interface ProjectService {

    Boolean checkDoesNotExist(String project);

    ProjectSimpleTransferModel saveProject(RegisterProjectBindingModel registerProjectBindingModel);

    List<ProjectSimpleTransferModel> getAllProjects();

    ProjectSimpleTransferModel enable(String id, Boolean setter);

    ProjectTransferModel findById(String id);

    ProjectActivityBindingModel addActivities(String id, String activityId);

    ProjectActivityBindingModel removeActivities(String id, String activityId);
}
