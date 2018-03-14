package softuni.org.project00.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.org.project00.app.models.dtos.view.CustomerIdViewDto;
import softuni.org.project00.app.models.dtos.view.CustomerSale;
import softuni.org.project00.app.repositories.CustomerRespository;
import softuni.org.project00.app.utils.ModelParser;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Todor Popov using Lenovo on 5.3.2018 г. at 20:37.
 */

@Service
public class CustomerServiceImp implements CustomerService {

    private final CustomerRespository customerRespository;
    private final ModelParser modelParser;

    @Autowired
    public CustomerServiceImp(CustomerRespository customerRespository, ModelParser modelParser) {
        this.customerRespository = customerRespository;
        this.modelParser = modelParser;
    }

    @Override
    public List<CustomerIdViewDto> getCustomers(String type) {
        if (type.equals("ascending")) {
            return this.modelParser.map(this.customerRespository.getCustomersAsc(), CustomerIdViewDto.class);
        }
        if (type.equals("descending")) {
            return this.modelParser.map(this.customerRespository.getCustomersDesc(), CustomerIdViewDto.class);
        }
        throw new IllegalArgumentException("Unnsuported method");
    }

    @Override
    public CustomerSale getCustomer(Long id) {
         Object[] customerInfo = (Object[]) this.customerRespository.getCustomerInfo(id);

        String name = customerInfo[0].toString();
        Long cars = Long.parseLong(customerInfo[1].toString());
        BigDecimal money = new BigDecimal(customerInfo[2].toString());

        CustomerSale customerSale = new CustomerSale(name, cars, money);
        return customerSale;
    }


}
