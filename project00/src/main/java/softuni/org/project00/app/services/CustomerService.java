package softuni.org.project00.app.services;

import org.springframework.stereotype.Service;
import softuni.org.project00.app.models.entities.Customer;

/**
 * Created by Todor Popov using Lenovo on 5.3.2018 г. at 20:36.
 */

public interface CustomerService {
    Customer[] getCustomers(String type);
}
