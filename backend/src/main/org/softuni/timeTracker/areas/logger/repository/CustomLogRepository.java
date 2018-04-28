package org.softuni.timeTracker.areas.logger.repository;

import org.softuni.timeTracker.areas.logger.entity.Logger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Todor Popov using Lenovo on 28.4.2018 г. at 12:38.
 */

@Repository
public interface CustomLogRepository extends JpaRepository<Logger, String> {

    @Query(nativeQuery = true,value = "SELECT COUNT(*) FROM logger AS l WHERE l.local_date_time >= now() - INTERVAL 1 DAY")
    Integer gerDaylyReport();

}
