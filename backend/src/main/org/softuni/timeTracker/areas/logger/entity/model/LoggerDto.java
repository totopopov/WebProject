package org.softuni.timeTracker.areas.logger.entity.model;

import java.time.LocalDateTime;

/**
 * Created by Todor Popov using Lenovo on 28.4.2018 г. at 12:42.
 */
public class LoggerDto {
    private LocalDateTime localDateTime;

    private String ip;


    public LoggerDto(LocalDateTime localDateTime, String ip) {
        this.localDateTime = localDateTime;
        this.ip = ip;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
