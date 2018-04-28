package org.softuni.timeTracker.areas.logger.service;

import org.softuni.timeTracker.areas.logger.entity.model.LoggerDto;

/**
 * Created by Todor Popov using Lenovo on 28.4.2018 г. at 12:40.
 */
public interface LoggerService {
    Boolean log(LoggerDto loggerDto);

    Integer getDailyReport();
}
