package org.softuni.timeTracker.areas.time.service;

import org.softuni.timeTracker.areas.time.entities.Activity;
import org.softuni.timeTracker.areas.time.models.activity.ActivityTransferModel;
import org.softuni.timeTracker.areas.time.models.activity.RegisterActivityBindingModel;
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

    public static final String ACTIVITY_WITH_FOLLOWING_ID_NOT_FOUND = "Activity with following id not found";
    private final ActivityRepository activityRepository;

    private final ModelParser modelParser;

    @Autowired
    public ActivityServiceImpl(ActivityRepository activityRepository, ModelParser modelParser) {
        this.activityRepository = activityRepository;
        this.modelParser = modelParser;
    }


    @Override
    public List<ActivityTransferModel> getAllActivities() {
        List<Activity> allActivity = this.activityRepository.findAll();

        return this.modelParser.map(allActivity, ActivityTransferModel.class);
    }

    @Override
    public ActivityTransferModel saveActivity(RegisterActivityBindingModel activityBindingModel) {
        Activity saved = this.activityRepository.save(this.modelParser.map(activityBindingModel, Activity.class));
        ActivityTransferModel mapedActivity = this.modelParser.map(saved, ActivityTransferModel.class);
        return mapedActivity;
    }

    @Override
    public Activity findActivity(String name) {

        return this.activityRepository.findByActivity(name);
    }

    @Override
    public Boolean checkDoesNotExist(String activity) {
        if (activity == null) {
            return false;
        }
        return this.activityRepository.findByActivity(activity) == null;
    }


    @Override
    public ActivityTransferModel enable(String id, Boolean setter) {
        Optional<Activity> activityOptional = this.activityRepository.findById(id);
        if (activityOptional.isPresent()) {
            Activity activity = activityOptional.get();
            activity.setEnabled(setter);
            return this.modelParser.map(activity, ActivityTransferModel.class);
        }

        return null;
    }

    @Override
    public Activity activity(String id) {
        Optional<Activity> activityOptional = this.activityRepository.findById(id);
        if (activityOptional.isPresent()) {
            return activityOptional.get();
        }

        throw new IllegalArgumentException(String.format("%s : %s", ACTIVITY_WITH_FOLLOWING_ID_NOT_FOUND, id));
    }

}
