package softuni.org.project00.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import softuni.org.project00.app.models.entities.Car;

import java.util.List;
import java.util.Optional;

/**
 * Created by Todor Popov using Lenovo on 5.3.2018 г. at 20:39.
 */

@Repository
public interface CarRespository extends JpaRepository<Car, Long> {

    @Query(value = "SELECT * FROM car_store.cars AS c " +
            "WHERE c.make=:make " +
            "ORDER BY c.model ASC , c.travelled_distance DESC ", nativeQuery = true)
    List<Car> getCars(@Param("make") String make);

    Optional<Car> findById(Long id);
}
