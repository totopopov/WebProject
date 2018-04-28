package org.softuni.timeTracker.areas.logger.service;

import org.softuni.timeTracker.areas.logger.entity.Logger;
import org.softuni.timeTracker.areas.logger.entity.model.LoggerDto;
import org.softuni.timeTracker.areas.logger.repository.CustomLogRepository;
import org.softuni.timeTracker.utils.ModelParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Todor Popov using Lenovo on 28.4.2018 г. at 12:40.
 */

@Service
@Transactional
public class LoggerServiceImp implements LoggerService {
    private CustomLogRepository customLogRepository;
    private ModelParser modelParser;

    @Autowired
    public LoggerServiceImp(CustomLogRepository customLogRepository, ModelParser modelParser) {
        this.customLogRepository = customLogRepository;
        this.modelParser = modelParser;
    }


    @Override
    public Boolean log(LoggerDto loggerDto) {
        Logger save = this.customLogRepository.save(this.modelParser.map(loggerDto, Logger.class));
        return Boolean.TRUE;
    }

    @Override
    public Integer getDailyReport() {
        return this.customLogRepository.gerDaylyReport();
    }

}
