package org.softuni.timeTracker.areas.time.repository;

import org.softuni.timeTracker.areas.time.entities.Activity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, String> {

    Activity findByActivity(String activity);

}