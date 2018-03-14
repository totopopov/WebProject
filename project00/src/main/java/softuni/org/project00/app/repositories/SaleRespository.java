package softuni.org.project00.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.org.project00.app.models.entities.Sale;

/**
 * Created by Todor Popov using Lenovo on 5.3.2018 г. at 20:39.
 */

@Repository
public interface SaleRespository extends JpaRepository<Sale, Long> {


}
