//package org.softuni.project01.auditorium.app.entities;
//
//import org.hibernate.annotations.GenericGenerator;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//import java.math.BigDecimal;
//import java.util.Date;
//
///**
// * Created by Todor Popov using Lenovo on 11.3.2018 г. at 12:53.
// */
//@Entity
//public class Occupation {
//
//    private String id;
//
//    public Occupation() {
//    }
//
//    @Id
//    @GeneratedValue(generator = "UUID")
//    @GenericGenerator(
//            name = "UUID",
//            strategy = "org.hibernate.id.UUIDGenerator"
//    )
//    @Column(name = "id", updatable = false, nullable = false)
//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }
//
//
//}
