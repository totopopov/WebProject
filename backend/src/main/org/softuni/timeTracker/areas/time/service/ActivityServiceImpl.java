package org.softuni.timeTracker.areas.time.service;

import org.softuni.timeTracker.areas.time.entities.Activity;
import org.softuni.timeTracker.areas.time.models.ActivityViewModel;
import org.softuni.timeTracker.areas.time.models.RegisterActivityBindingModel;
import org.softuni.timeTracker.areas.time.repository.ActivityRepository;
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
public class ActivityServiceImpl implements ActivityService {

    private final ActivityRepository activityRepository;

    private final ModelParser modelParser;

    @Autowired
    public ActivityServiceImpl(ActivityRepository activityRepository, ModelParser modelParser) {
        this.activityRepository = activityRepository;
        this.modelParser = modelParser;
    }


    @Override
    public List<ActivityViewModel> getAllActivities() {
        List<Activity> allActivity = this.activityRepository.findAll();

        return this.modelParser.map(allActivity, ActivityViewModel.class);
    }

    @Override
    public ActivityViewModel saveActivity(RegisterActivityBindingModel activityBindingModel) {
        Activity saved = this.activityRepository.save(this.modelParser.map(activityBindingModel, Activity.class));
        ActivityViewModel mapedActivity = this.modelParser.map(saved, ActivityViewModel.class);
        return mapedActivity;
    }

    @Override
    public Boolean CheckDoesNotExist(String activity) {
        if (activity == null) {
            return false;
        }
        return this.activityRepository.findByActivity(activity) == null;
    }


    @Override
    public ActivityViewModel enable(String id, Boolean setter) {
        Optional<Activity> activityOptional = this.activityRepository.findById(id);
        if (activityOptional.isPresent()) {
            Activity activity = activityOptional.get();
            activity.setEnabled(setter);
            return this.modelParser.map(activity, ActivityViewModel.class);
        }

        return null;
    }

}
