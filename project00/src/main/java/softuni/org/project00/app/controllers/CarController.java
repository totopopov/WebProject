package softuni.org.project00.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import softuni.org.project00.app.models.dtos.view.CarIdViewDto;
import softuni.org.project00.app.models.dtos.view.CarViewDto;
import softuni.org.project00.app.models.dtos.view.PartViewDto;
import softuni.org.project00.app.services.CarService;
import softuni.org.project00.app.services.PartService;

import java.util.List;

/**
 * Created by Todor Popov using Lenovo on 5.3.2018 г. at 18:38.
 */

@Controller
@RequestMapping("/cars")
public class CarController {

    private final CarService carService;
    private final PartService partService;

    @Autowired
    public CarController(CarService carService, PartService partService) {
        this.carService = carService;
        this.partService = partService;
    }

    @GetMapping("/{make}")
    public ModelAndView index(@PathVariable String make) {

        List<CarViewDto> cars = this.carService.getCars(make);


        return new ModelAndView("cars/cars", "cars", cars);
    }

    @GetMapping("")
    public ModelAndView index() {

        List<CarIdViewDto> cars = this.carService.getAllCars();


        return new ModelAndView("cars/cars", "cars", cars);
    }

    @GetMapping("/{id}/parts")
    public String carParts(Model model, @PathVariable String id) {
        long longId = Long.parseLong(id);
        List<PartViewDto> parts = this.partService.getParts(longId);
        CarViewDto carById = this.carService.getCarById(longId);

        model.addAttribute("parts", parts);
        model.addAttribute("carById", carById);

        if (carById==null){
            //TODO Handle Error
            return null;
        }

        return "cars/car_parts";
    }


}
