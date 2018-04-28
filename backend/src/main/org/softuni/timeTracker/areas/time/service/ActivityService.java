package org.softuni.timeTracker.areas.time.service;

import org.softuni.timeTracker.areas.time.entities.Activity;
import org.softuni.timeTracker.areas.time.models.activity.ActivityTransferModel;
import org.softuni.timeTracker.areas.time.models.activity.RegisterActivityBindingModel;

import java.util.List;

/**
 * Created by Todor Popov using Lenovo on 27.4.2018 г. at 14:06.
 */
public interface ActivityService {
    List<ActivityTransferModel> getAllActivities();

    ActivityTransferModel saveActivity(RegisterActivityBindingModel activityBindingModel);

    Activity findActivity(String name);

    Boolean checkDoesNotExist(String activity);


    ActivityTransferModel enable(String id, Boolean setter);

    Activity activity(String id);
}
