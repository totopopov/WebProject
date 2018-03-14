package softuni.org.project00.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.org.project00.app.models.dtos.view.CarIdViewDto;
import softuni.org.project00.app.models.dtos.view.CarViewDto;
import softuni.org.project00.app.models.entities.Car;
import softuni.org.project00.app.repositories.CarRespository;
import softuni.org.project00.app.utils.ModelParser;

import java.util.List;
import java.util.Optional;

/**
 * Created by Todor Popov using Lenovo on 5.3.2018 г. at 20:37.
 */

@Service
public class CarServiceImp implements CarService {

    private final CarRespository carRespository;
    private ModelParser modelParser;

    @Autowired
    public CarServiceImp(CarRespository carRespository, ModelParser modelParser) {
        this.carRespository = carRespository;
        this.modelParser = modelParser;
    }

    @Override
    public List<CarViewDto> getCars(String make) {
        return this.modelParser.map(this.carRespository.getCars(make), CarViewDto.class);
    }

    @Override
    public List<CarIdViewDto> getAllCars() {
        return this.modelParser.map(this.carRespository.findAll(), CarIdViewDto.class);
    }


    @Override
    public CarViewDto getCarById(Long id) {
        Optional<Car> CarById = this.carRespository.findById(id);

        if (CarById.isPresent()) {
            return this.modelParser.map(CarById.get(), CarViewDto.class);
        }

        return null;
    }

}
