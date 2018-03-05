package softuni.org.project00.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import softuni.org.project00.app.models.entities.Customer;
import softuni.org.project00.app.services.CustomerService;

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
    public ModelAndView index(@PathVariable String type) {
        if (!type.equals("ascending") && !type.equals("descending")) {
//             return new ModelAndView("forward:/redirectedUrl", model);
            return null;
        }

        Customer[] customers = this.customerService.getCustomers(type);

        System.out.println("works");

        return new ModelAndView("customers/customers", "customers", customers);
    }


}
