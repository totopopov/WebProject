package org.softuni.timeTracker.areas.time.service;


import org.softuni.timeTracker.areas.time.entities.TimeUnit;
import org.softuni.timeTracker.areas.time.models.timeUnit.RegisterTimeUnitBindingModel;

/**
 * Created by Todor Popov using Lenovo on 27.4.2018 г. at 14:06.
 */
public interface TimeUnitService {

    TimeUnit registerEntry(RegisterTimeUnitBindingModel entry);
}
