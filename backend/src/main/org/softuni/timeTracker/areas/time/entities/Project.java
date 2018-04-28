package org.softuni.timeTracker.areas.time.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "project")
public class Project {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )

    @Column(name = "id", updatable = false, nullable = false)
    private String id;

    private String project;

    private String description;

    private Boolean enabled;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "project_activities", joinColumns = @JoinColumn(name = "project_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "activty_id", referencedColumnName = "id"))
    private Set<Activity> activities;


    public Project() {
        this.activities = new HashSet<>();
    }

    public String getId() {
        return id;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public Set<Activity> getActivities() {
        return activities;
    }

    public void setActivities(Set<Activity> activities) {
        this.activities = activities;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }


    @Transient
    public List<String> getSimpleActivities() {
        return activities.stream().map(Activity::getActivity).collect(Collectors.toList());
    }

    @Transient
    public void setActivities() {

    }

    @Transient
    public Boolean addActivity(Activity activity) {
        return this.activities.add(activity);
    }

    @Transient
    public Boolean removeActivity(Activity activity) {
        return this.activities.remove(activity);
    }
}
