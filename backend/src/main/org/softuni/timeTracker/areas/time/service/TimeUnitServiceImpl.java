package org.softuni.timeTracker.areas.time.service;


import org.softuni.timeTracker.areas.time.entities.Activity;
import org.softuni.timeTracker.areas.time.entities.Project;
import org.softuni.timeTracker.areas.time.entities.TimeUnit;
import org.softuni.timeTracker.areas.time.models.timeUnit.RegisterTimeUnitBindingModel;
import org.softuni.timeTracker.areas.time.models.timeUnit.TimeUnitSimpleTransferModel;
import org.softuni.timeTracker.areas.time.repository.TimeUnitRepository;
import org.softuni.timeTracker.areas.user.entities.User;
import org.softuni.timeTracker.areas.user.service.UserService;
import org.softuni.timeTracker.utils.ModelParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Todor Popov using Lenovo on 27.4.2018 г. at 14:06.
 */

@Service
@Transactional
public class TimeUnitServiceImpl implements TimeUnitService {


    private final ModelParser modelParser;
    private TimeUnitRepository timeUnitRepository;
    private ProjectService projectService;
    private ActivityService activityService;
    private UserService userService;

    @Autowired
    public TimeUnitServiceImpl(ModelParser modelParser, TimeUnitRepository timeUnitRepository, ProjectService projectService, ActivityService activityService, UserService userService) {
        this.modelParser = modelParser;
        this.timeUnitRepository = timeUnitRepository;
        this.projectService = projectService;
        this.activityService = activityService;
        this.userService = userService;
    }


    @Override
    public TimeUnitSimpleTransferModel registerEntry(RegisterTimeUnitBindingModel entry) {
        TimeUnit mapedEntry = this.modelParser.map(entry, TimeUnit.class);
        Project project = this.projectService.findProject(entry.getProject());
        Activity activity = this.activityService.findActivity(entry.getActivity());
        User user = this.userService.userByName(SecurityContextHolder.getContext().getAuthentication().
                getPrincipal().toString());
        mapedEntry.setActivity(activity);
        mapedEntry.setProject(project);
        mapedEntry.setUser(user);
        this.timeUnitRepository.save(mapedEntry);
        return this.modelParser.map(mapedEntry, TimeUnitSimpleTransferModel.class);
    }

    @Override
    public List<TimeUnitSimpleTransferModel> getAllEntries() {
        User user = this.userService.userByName(SecurityContextHolder.getContext().getAuthentication().
                getPrincipal().toString());
        List<TimeUnit> all = this.timeUnitRepository.getAllByUserEquals(user);
        List<TimeUnitSimpleTransferModel> mappedEntries = this.modelParser.map(all, TimeUnitSimpleTransferModel.class);
        return mappedEntries;
    }
}
