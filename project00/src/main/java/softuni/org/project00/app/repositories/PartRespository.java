package softuni.org.project00.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import softuni.org.project00.app.models.dtos.view.PartViewDto;
import softuni.org.project00.app.models.entities.Car;
import softuni.org.project00.app.models.entities.Part;

import java.util.List;

/**
 * Created by Todor Popov using Lenovo on 5.3.2018 г. at 20:39.
 */

@Repository
public interface PartRespository extends JpaRepository<Part, Long> {

    @Query(value = "SELECT * FROM car_store.parts AS p " +
            "INNER JOIN car_store.parts_cars AS pc ON pc.part_id=p.id " +
            "WHERE pc.car_id=:carId " +
            "ORDER BY p.name ASC ", nativeQuery = true)
    List<Part> getParts(@Param("carId") Long carId);

}
