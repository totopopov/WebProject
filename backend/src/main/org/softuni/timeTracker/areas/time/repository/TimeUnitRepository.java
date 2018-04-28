package org.softuni.timeTracker.areas.time.repository;


import org.softuni.timeTracker.areas.time.entities.TimeUnit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TimeUnitRepository extends JpaRepository<TimeUnit, String> {


}