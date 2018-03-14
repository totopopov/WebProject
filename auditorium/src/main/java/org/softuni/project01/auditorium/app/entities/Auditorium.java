package org.softuni.project01.auditorium.app.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Todor Popov using Lenovo on 11.3.2018 г. at 12:49.
 */

@Entity
@Table(name = "auditoriums")
public class Auditorium {

    private Long id;
    private String name;
    private Integer maxCapacity;
    private Boolean liveStream;
    private ChairType chairType;
    private TableType tableType;
    private List<DailySchedule> dailySchedules;


    public Auditorium() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Enumerated(EnumType.STRING)
    public ChairType getChairType() {
        return chairType;
    }


    public void setChairType(ChairType chairType) {
        this.chairType = chairType;
    }

    @Enumerated(EnumType.STRING)
    public TableType getTableType() {
        return tableType;
    }

    public void setTableType(TableType tableType) {
        this.tableType = tableType;
    }


    @OneToMany(mappedBy = "auditorium")
    public List<DailySchedule> getDailySchedules() {
        return dailySchedules;
    }

    public void setDailySchedules(List<DailySchedule> dailySchedules) {
        this.dailySchedules = dailySchedules;
    }
}
