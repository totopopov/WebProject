package org.softuni.project01.auditorium.app.dto.binding;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by Todor Popov using Lenovo on 11.3.2018 г. at 23:29.
 */

@Component
public class SearchBindingModel {

    private Date date;
    private Integer startHour;
    private Integer endHour;

    public SearchBindingModel() {
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getStartHour() {
        return startHour;
    }

    public void setStartHour(Integer startHour) {
        this.startHour = startHour;
    }

    public Integer getEndHour() {
        return endHour;
    }

    public void setEndHour(Integer endHour) {
        this.endHour = endHour;
    }
}
