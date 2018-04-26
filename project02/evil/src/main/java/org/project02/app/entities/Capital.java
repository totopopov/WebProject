package org.project02.app.entities;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by Todor Popov using Lenovo on 15.3.2018 г. at 23:20.
 */

@Entity
public class Capital {
    private Long id;
    private String name;
    private BigDecimal latitude;
    private BigDecimal longitude;


    public Capital() {
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
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

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }


    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }


}
