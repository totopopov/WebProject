package org.softuni.timeTracker.areas.time.service;


import org.softuni.timeTracker.areas.time.models.timeUnit.RegisterTimeUnitBindingModel;
import org.softuni.timeTracker.areas.time.models.timeUnit.TimeUnitSimpleTransferModel;

/**
 * Created by Todor Popov using Lenovo on 27.4.2018 г. at 14:06.
 */
public interface TimeUnitService {

    TimeUnitSimpleTransferModel registerEntry(RegisterTimeUnitBindingModel entry);
}
