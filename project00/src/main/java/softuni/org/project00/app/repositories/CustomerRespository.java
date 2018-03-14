package softuni.org.project00.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import softuni.org.project00.app.models.dtos.view.CustomerSale;
import softuni.org.project00.app.models.entities.Customer;

import java.util.List;

/**
 * Created by Todor Popov using Lenovo on 5.3.2018 г. at 20:39.
 */

@Repository
public interface CustomerRespository extends JpaRepository<Customer,Long>{

    @Query(value ="SELECT * from car_store.customers AS u " +
            "ORDER BY u.birth_date ASC, u.is_young_driver, u.name" ,nativeQuery = true)
    List<Customer> getCustomersAsc();

    @Query(value ="SELECT * from car_store.customers AS u " +
            "ORDER BY u.birth_date DESC, u.is_young_driver, u.name" ,nativeQuery = true)
    List<Customer> getCustomersDesc();


    @Query(value = "SELECt c.name, COUNT(s.id) , SUM(sal.sm*(1-s.discount)) FROM customers as c " +
            "INNER JOIN sales AS s ON s.customer_id = c.id " +
            "INNER JOIN (SELECT pc.car_id AS id , SUM(p.price) AS sm FROM parts AS p " +
            " INNER JOIN parts_cars AS pc ON pc.part_id-p.id " +
            " GROUP BY pc.car_id) AS `sal` ON sal.id= s.car_id " +
            " WHERE c.id=:Personid " +
            " GROUP BY c.id ",nativeQuery = true)
    Object getCustomerInfo(@Param("Personid") Long personId);

}
