package softuni.org.project00.app.services;

import softuni.org.project00.app.models.dtos.view.CarIdViewDto;
import softuni.org.project00.app.models.dtos.view.CarViewDto;
import softuni.org.project00.app.models.dtos.view.SaleViewDto;

import java.util.List;

/**
 * Created by Todor Popov using Lenovo on 5.3.2018 г. at 20:36.
 */

public interface SaleService {


    List<SaleViewDto> getAllSales();

    SaleViewDto getSingeSale(Long id);
}
