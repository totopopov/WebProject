package org.softuni.timeTracker.areas.time;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "activities")
public class Activity {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )

    @Column(name = "id", updatable = false, nullable = false)
    private String id;

    private String activity;

    private String activityKPI;

    private String description;

    public Activity() {
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getActivityKPI() {
        return activityKPI;
    }

    public void setActivityKPI(String activityKPI) {
        this.activityKPI = activityKPI;
    }
}
