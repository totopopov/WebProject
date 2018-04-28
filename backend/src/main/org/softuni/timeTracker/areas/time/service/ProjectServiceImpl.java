package org.softuni.timeTracker.areas.time.service;


import org.softuni.timeTracker.areas.time.entities.Activity;
import org.softuni.timeTracker.areas.time.entities.Project;
import org.softuni.timeTracker.areas.time.models.ProjectActivityBindingModel;
import org.softuni.timeTracker.areas.time.models.activity.ActivityTransferModel;
import org.softuni.timeTracker.areas.time.models.project.ProjectSimpleTransferModel;
import org.softuni.timeTracker.areas.time.models.project.ProjectTransferModel;
import org.softuni.timeTracker.areas.time.models.project.RegisterProjectBindingModel;
import org.softuni.timeTracker.areas.time.repository.ProjectRepository;
import org.softuni.timeTracker.utils.ModelParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Created by Todor Popov using Lenovo on 27.4.2018 г. at 14:06.
 */

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {

    public static final String PROJECT_WITH_FOLLOWING_ID_NOT_FOUND = "Project with following Id not found";
    private final ProjectRepository projectRepository;
    private final ModelParser modelParser;
    private final ActivityService activityService;

    @Autowired
    public ProjectServiceImpl(ProjectRepository projectRepository, ModelParser modelParser, ActivityService activityService) {
        this.projectRepository = projectRepository;
        this.modelParser = modelParser;
        this.activityService = activityService;
    }

    @Override
    public Boolean checkDoesNotExist(String project) {
        if (project == null) {
            return false;
        }
        return this.projectRepository.findByProject(project) == null;
    }

    @Override
    public ProjectSimpleTransferModel saveProject(RegisterProjectBindingModel registerProjectBindingModel) {
        Project saved = this.projectRepository.save(this.modelParser.map(registerProjectBindingModel, Project.class));
        ProjectSimpleTransferModel mapedActivity = this.modelParser.map(saved, ProjectSimpleTransferModel.class);
        return mapedActivity;
    }

    @Override
    public List<ProjectSimpleTransferModel> getAllProjects() {
        List<ProjectSimpleTransferModel> projects = this.modelParser.map(this.projectRepository.findAll(), ProjectSimpleTransferModel.class);

        return projects;
    }

    @Override
    public ProjectSimpleTransferModel enable(String id, Boolean setter) {

        Optional<Project> projectOptional = this.projectRepository.findById(id);
        if (projectOptional.isPresent()) {
            Project project = projectOptional.get();
            project.setEnabled(setter);
            return this.modelParser.map(project, ProjectSimpleTransferModel.class);
        }

        throw new IllegalArgumentException(String.format("%s : %s", PROJECT_WITH_FOLLOWING_ID_NOT_FOUND, id));
    }

    @Override
    public ProjectTransferModel findById(String id) {
        Optional<Project> projectOptional = this.projectRepository.findById(id);
        if (projectOptional.isPresent()) {
            Project project = projectOptional.get();
            ProjectTransferModel mapedProject = this.modelParser.map(project, ProjectTransferModel.class);
            return mapedProject;
        }
        throw new IllegalArgumentException(String.format("%s : %s", PROJECT_WITH_FOLLOWING_ID_NOT_FOUND, id));
    }

    @Override
    public ProjectActivityBindingModel addActivities(String id, String activityId) {
        Optional<Project> projectOptional = this.projectRepository.findById(id);

        if (projectOptional.isPresent()) {
            Project project = projectOptional.get();
            Activity activity = this.activityService.activity(activityId);
            project.addActivity(activity);
            this.projectRepository.save(project);
            ProjectTransferModel mapedProject = this.modelParser.map(project, ProjectTransferModel.class);
            ActivityTransferModel mappedActivity = this.modelParser.map(activity, ActivityTransferModel.class);
            ProjectActivityBindingModel projectActivityBindingModel = new ProjectActivityBindingModel(mapedProject, mappedActivity);
            return projectActivityBindingModel;
        }
        throw new IllegalArgumentException(String.format("%s : %s", PROJECT_WITH_FOLLOWING_ID_NOT_FOUND, id));
    }


    @Override
    public ProjectActivityBindingModel removeActivities(String id, String activityId) {
        Optional<Project> projectOptional = this.projectRepository.findById(id);

        if (projectOptional.isPresent()) {
            Project project = projectOptional.get();
            Activity activity = this.activityService.activity(activityId);
            project.removeActivity(activity);
            this.projectRepository.save(project);
            ProjectTransferModel mapedProject = this.modelParser.map(project, ProjectTransferModel.class);
            ActivityTransferModel mappedActivity = this.modelParser.map(activity, ActivityTransferModel.class);
            ProjectActivityBindingModel projectActivityBindingModel = new ProjectActivityBindingModel(mapedProject, mappedActivity);
            return projectActivityBindingModel;
        }
        throw new IllegalArgumentException(String.format("%s : %s", PROJECT_WITH_FOLLOWING_ID_NOT_FOUND, id));
    }


}
