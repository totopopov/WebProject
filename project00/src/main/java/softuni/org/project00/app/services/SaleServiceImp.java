package softuni.org.project00.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.org.project00.app.models.dtos.view.SaleViewDto;
import softuni.org.project00.app.models.entities.Sale;
import softuni.org.project00.app.repositories.SaleRespository;
import softuni.org.project00.app.utils.ModelParser;

import java.util.List;
import java.util.Optional;

/**
 * Created by Todor Popov using Lenovo on 5.3.2018 г. at 20:37.
 */

@Service
public class SaleServiceImp implements SaleService {

    private final SaleRespository saleRespository;
    private ModelParser modelParser;

    @Autowired
    public SaleServiceImp(SaleRespository saleRespository, ModelParser modelParser) {
        this.saleRespository = saleRespository;
        this.modelParser = modelParser;
    }

    @Override
    public List<SaleViewDto> getAllSales() {
        return this.modelParser.map(this.saleRespository.findAll(), SaleViewDto.class);
    }

    @Override
    public SaleViewDto getSingeSale(Long id) {
        Optional<Sale> byId = this.saleRespository.findById(id);
        return this.modelParser.map(byId.get(), SaleViewDto.class);
    }

}
