package org.softuni.project01.auditorium.app.entities;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by Todor Popov using Lenovo on 11.3.2018 г. at 13:18.
 */


@Entity
public class DailySchedule {

    private Long id;
    private Date date;
    private Auditorium auditorium;
    private List<DailySlot> workingSlots;

    public DailySchedule() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    @OneToMany(mappedBy = "dailySchedule")
    public List<DailySlot> getWorkingSlots() {
        return workingSlots;
    }

    public void setWorkingSlots(List<DailySlot> workingSlots) {
        this.workingSlots = workingSlots;
    }

    @Column(columnDefinition = "DATE")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @ManyToOne
    @JoinColumn(name = "auditorium_id")
    public Auditorium getAuditorium() {
        return auditorium;
    }

    public void setAuditorium(Auditorium auditorium) {
        this.auditorium = auditorium;
    }
}
