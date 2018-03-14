package softuni.org.project00.app.services;

import softuni.org.project00.app.models.dtos.view.CarIdViewDto;
import softuni.org.project00.app.models.dtos.view.CarViewDto;

import java.util.List;

/**
 * Created by Todor Popov using Lenovo on 5.3.2018 г. at 20:36.
 */

public interface CarService {

    List<CarViewDto> getCars(String make);

    List<CarIdViewDto> getAllCars();

    CarViewDto getCarById(Long id);
}
