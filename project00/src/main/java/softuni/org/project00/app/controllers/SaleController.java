package softuni.org.project00.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import softuni.org.project00.app.models.dtos.view.CarViewDto;
import softuni.org.project00.app.models.dtos.view.CustomerSale;
import softuni.org.project00.app.models.dtos.view.SaleViewDto;
import softuni.org.project00.app.services.SaleService;

import java.util.List;

/**
 * Created by Todor Popov using Lenovo on 14.3.2018 г. at 23:39.
 */

@Controller
@RequestMapping("/sales")
public class SaleController {

    private final SaleService saleService;

    @Autowired
    public SaleController(SaleService saleService) {
        this.saleService = saleService;
    }


    @GetMapping("")
    public ModelAndView getSales() {

        List<SaleViewDto> allSales = this.saleService.getAllSales();


        return new ModelAndView("sales/sales", "sales", allSales);
    }


    @GetMapping("/{id}")
    public ModelAndView getSingleSale(@PathVariable String id) {

        Long personId=Long.parseLong(id);

        SaleViewDto singeSale = this.saleService.getSingeSale(personId);

        return new ModelAndView("sales/sale", "singeSale", singeSale);
    }

}
