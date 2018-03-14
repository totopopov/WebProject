package org.softuni.project01.auditorium.app.reposityory;

import org.softuni.project01.auditorium.app.entities.Auditorium;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


/**
 * Created by Todor Popov using Lenovo on 11.3.2018 г. at 21:14.
 */

@Repository
public interface AuditoriumRepository extends JpaRepository<Auditorium, String> {

    @Query(value = "SELECT ab.name, ab.max_capacity, ab.live_stream, AVG(ds.price), ab.chair_type, ab.table_type FROM auditoriums AS ab " +
            "INNER JOIN daily_schedule as d ON d.auditorium_id = ab.id " +
            "INNER JOIN daily_slot as ds ON ds.daily_schedule_id = d.id " +
            "WHERE d.date=:date AND ds.start_hour>=:start  AND ds.end_hour <= :end " +
            "GROUP BY ab.id ",
            countQuery = "SELECT COUNT(*) FROM (SELECT ab.name, ab.max_capacity, ab.live_stream, AVG(ds.price), ab.chair_type, ab.table_type FROM auditoriums AS ab " +
                    "                    INNER JOIN daily_schedule as d ON d.auditorium_id = ab.id " +
                    "                    INNER JOIN daily_slot as ds ON ds.daily_schedule_id = d.id  " +
                    "                    WHERE d.date=\"2018-04-04\" AND ds.start_hour>=10  AND ds.end_hour <= 22 " +
                    "                    GROUP BY ab.id) as b",
            nativeQuery = true)
    Page<Object[]> findRooms(@Param("date")String date, @Param("start") Integer start, @Param("end") Integer end, Pageable pageable);

}
