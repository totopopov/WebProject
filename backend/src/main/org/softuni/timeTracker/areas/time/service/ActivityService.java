package org.softuni.timeTracker.areas.time.service;

import org.softuni.timeTracker.areas.time.models.ActivityViewModel;
import org.softuni.timeTracker.areas.time.models.RegisterActivityBindingModel;

import java.util.List;

/**
 * Created by Todor Popov using Lenovo on 27.4.2018 г. at 14:06.
 */
public interface ActivityService {
    List<ActivityViewModel> getAllActivities();

    ActivityViewModel saveActivity(RegisterActivityBindingModel activityBindingModel);

    Boolean CheckDoesNotExist(String activity);


    ActivityViewModel enable(String id, Boolean setter);
}
