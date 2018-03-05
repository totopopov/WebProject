package softuni.org.project00.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.org.project00.app.models.entities.Customer;

/**
 * Created by Todor Popov using Lenovo on 5.3.2018 г. at 20:39.
 */

@Repository
public interface CustomerRespository extends JpaRepository<Customer,Long>{

    @Query(value ="SELECT * from car_store.customers AS u " +
            "ORDER BY u.birth_date ASC, u.is_young_driver" ,nativeQuery = true)
    Customer[] getCustomersAsc();

    @Query(value ="SELECT * from car_store.customers AS u " +
            "ORDER BY u.birth_date DESC, u.is_young_driver" ,nativeQuery = true)
    Customer[] getCustomersDesc();
}
