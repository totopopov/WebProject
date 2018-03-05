package softuni.org.project00.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.org.project00.app.models.entities.Customer;
import softuni.org.project00.app.repositories.CustomerRespository;

/**
 * Created by Todor Popov using Lenovo on 5.3.2018 г. at 20:37.
 */

@Service
public class CustomerServiceImp implements CustomerService {

    private final CustomerRespository customerRespository;

    @Autowired
    public CustomerServiceImp(CustomerRespository customerRespository) {
        this.customerRespository = customerRespository;
    }

    @Override
    public Customer[] getCustomers(String type) {
        if (type.equals("ascending")){
            return this.customerRespository.getCustomersAsc();
        }
        if (type.equals("descending")){
            return this.customerRespository.getCustomersDesc();
        }
        throw new IllegalArgumentException("Unnsuported method");
    }
}
