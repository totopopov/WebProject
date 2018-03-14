package org.softuni.project01.auditorium.app.dto.view;

import org.softuni.project01.auditorium.app.entities.ChairType;
import org.softuni.project01.auditorium.app.entities.TableType;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * Created by Todor Popov using Lenovo on 11.3.2018 г. at 23:46.
 */

@Component
public class AuditoriumVIewModel {
    private String name;
    private Integer maxCapacity;
    private Boolean liveStream;
    private BigDecimal price;
    private ChairType chairType;
    private TableType tableType;

    public AuditoriumVIewModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(Integer maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public Boolean getLiveStream() {
        return liveStream;
    }

    public void setLiveStream(Boolean liveStream) {
        this.liveStream = liveStream;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public ChairType getChairType() {
        return chairType;
    }

    public void setChairType(ChairType chairType) {
        this.chairType = chairType;
    }

    public TableType getTableType() {
        return tableType;
    }

    public void setTableType(TableType tableType) {
        this.tableType = tableType;
    }
}
