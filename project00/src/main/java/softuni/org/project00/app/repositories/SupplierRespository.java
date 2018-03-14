package softuni.org.project00.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import softuni.org.project00.app.models.entities.Car;
import softuni.org.project00.app.models.entities.Supplier;

import java.util.List;

/**
 * Created by Todor Popov using Lenovo on 5.3.2018 г. at 20:39.
 */

@Repository
public interface SupplierRespository extends JpaRepository<Supplier, Long> {

    @Query(value = "SELECT * FROM car_store.suppliers AS s " +
            "WHERE s.is_importer=:importer " +
            "ORDER BY s.name ASC ", nativeQuery = true)
    List<Supplier> getSuppliers(@Param("importer") Boolean importer);
}
