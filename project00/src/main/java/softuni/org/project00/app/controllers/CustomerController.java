package softuni.org.project00.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import softuni.org.project00.app.models.dtos.view.CustomerIdViewDto;
import softuni.org.project00.app.models.dtos.view.CustomerSale;
import softuni.org.project00.app.models.dtos.view.CustomerViewDto;
import softuni.org.project00.app.services.CustomerService;

import java.util.List;

/**
 * Created by Todor Popov using Lenovo on 5.3.2018 г. at 18:38.
 */

@Controller
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @GetMapping("/all/{type}")
    public ModelAndView customers(@PathVariable String type) {
        if (!type.equals("ascending") && !type.equals("descending")) {
//             return new ModelAndView("forward:/redirectedUrl", model);
            return null;
        }

        List<CustomerIdViewDto> customers = this.customerService.getCustomers(type);

        return new ModelAndView("customers/customers", "customers", customers);
    }

    @GetMapping("/{id}")
    public ModelAndView customerData(@PathVariable String id) {

        Long personId=Long.parseLong(id);

        CustomerSale customer = this.customerService.getCustomer(personId);

        return new ModelAndView("customers/customer", "customer", customer);
    }


}
