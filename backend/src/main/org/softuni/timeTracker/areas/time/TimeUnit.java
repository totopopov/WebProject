package org.softuni.timeTracker.areas.time;

import org.hibernate.annotations.GenericGenerator;
import org.softuni.timeTracker.areas.user.entities.User;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "time_unit")
public class TimeUnit {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )

    @Column(name = "id", updatable = false, nullable = false)
    private String id;

    private Date date;

    private Double time;

    private Integer taskCompleted;

    private String commnets;

    @ManyToOne
    @JoinColumn(name = "project_id", referencedColumnName = "id", nullable = false)
    private Project project;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;


}
