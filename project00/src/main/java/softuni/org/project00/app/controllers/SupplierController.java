package softuni.org.project00.app.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import softuni.org.project00.app.models.dtos.view.SupplierViewDto;
import softuni.org.project00.app.services.SupplierService;

import java.util.List;

/**
 * Created by Todor Popov using Lenovo on 5.3.2018 г. at 18:38.
 */

@Controller
@RequestMapping("/suppliers")
public class SupplierController {


    private final SupplierService supplierService;

    @Autowired
    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }


    @GetMapping("/{type}")
    public ModelAndView index(@PathVariable String type) {

        if (!type.equals("local") && !type.equals("importers")) {
//             return new ModelAndView("forward:/redirectedUrl", model);
            return null;
        }

        List<SupplierViewDto> supliers = this.supplierService.getSupliers(type);


        return new ModelAndView("suppliers/suppliers", "supliers", supliers);
    }


}
