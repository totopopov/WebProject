package org.softuni.timeTracker.areas.time.service;

import org.softuni.timeTracker.areas.time.entities.Project;
import org.softuni.timeTracker.areas.time.models.ProjectActivityBindingModel;
import org.softuni.timeTracker.areas.time.models.project.ProjectSimpleTransferModel;
import org.softuni.timeTracker.areas.time.models.project.ProjectTransferModel;
import org.softuni.timeTracker.areas.time.models.project.RegisterProjectBindingModel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Todor Popov using Lenovo on 27.4.2018 г. at 14:06.
 */
public interface ProjectService {

    Boolean checkDoesNotExist(String project);

    Project findProject(String id);

    ProjectSimpleTransferModel saveProject(RegisterProjectBindingModel registerProjectBindingModel);

    List<ProjectSimpleTransferModel> getAllProjects();

    Map<String, ProjectTransferModel> getAllActiveProjects();

    ProjectSimpleTransferModel enable(String id, Boolean setter);

    ProjectTransferModel findById(String id);

    ProjectActivityBindingModel addActivities(String id, String activityId);

    ProjectActivityBindingModel removeActivities(String id, String activityId);
}
