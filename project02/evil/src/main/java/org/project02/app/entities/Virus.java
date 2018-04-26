package org.project02.app.entities;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by Todor Popov using Lenovo on 15.3.2018 г. at 23:25.
 */

@Entity
@Table(name = "capitals")
public class Virus {
    private Long id;
    private String name;
    private String description;
    private String sideEfects;
    private String creator;
    private Boolean deadly;
    private Boolean cureable;
    private Mutation mutation;
    private Short turnoverRate;
    private Short hourUntilTurn;
    private Magnitude magnitude;
    private Date releaseOn;

    private Set<Capital> capitals;


    public Virus() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NotNull
    @Size(min = 3,max = 11)
    @Column(columnDefinition = "VARCHAR(12)")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotNull
    @Size(min = 5,max = 101)
    @Column(columnDefinition = "TEXT",length = 101)
    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }

    @Size(max = 51)
    @Column(columnDefinition = "VARCHAR(51)")
    public String getSideEfects() {
        return sideEfects;
    }

    public void setSideEfects(String sideEfects) {
        this.sideEfects = sideEfects;
    }

    @Pattern(regexp = "(corp|Corp)")
    @Column(columnDefinition = "VARCHAR(5)")
    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Boolean getDeadly() {
        return deadly;
    }

    public void setDeadly(Boolean deadly) {
        this.deadly = deadly;
    }

    public Boolean getCureable() {
        return cureable;
    }

    public void setCureable(Boolean cureable) {
        this.cureable = cureable;
    }

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(10)")
    public Mutation getMutation() {
        return mutation;
    }

    public void setMutation(Mutation mutation) {
        this.mutation = mutation;
    }

    @Max(value = 100,message = "Value should be less than 100")
    @Min(value = 0,message = "Value should be greater than 0")
    public Short getTurnoverRate() {
        return turnoverRate;
    }

    public void setTurnoverRate(Short turnoverRate) {
        this.turnoverRate = turnoverRate;
    }
    @Max(value = 12,message = "Value should be less than 12")
    @Min(value = 1,message = "Value should be greater than 1")
    public Short getHourUntilTurn() {
        return hourUntilTurn;
    }

    public void setHourUntilTurn(Short hourUntilTurn) {
        this.hourUntilTurn = hourUntilTurn;
    }

    @Enumerated(value = EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(10)")
    public Magnitude getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(Magnitude magnitude) {
        this.magnitude = magnitude;
    }

    @Past
    public Date getReleaseOn() {
        return releaseOn;
    }

    public void setReleaseOn(Date releaseOn) {
        this.releaseOn = releaseOn;
    }

    @ManyToMany()
    @JoinTable(name = "viruses_capitals",
            joinColumns = {@JoinColumn(name = "virus_id",referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "capital_id",referencedColumnName = "id")})
    public Set<Capital> getCapitals() {
        return capitals;
    }

    public void setCapitals(Set<Capital> capitals) {
        this.capitals = capitals;
    }
}
