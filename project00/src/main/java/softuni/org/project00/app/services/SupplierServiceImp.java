package softuni.org.project00.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.org.project00.app.models.dtos.view.SupplierViewDto;
import softuni.org.project00.app.repositories.SupplierRespository;
import softuni.org.project00.app.utils.ModelParser;

import java.util.List;

/**
 * Created by Todor Popov using Lenovo on 5.3.2018 г. at 20:37.
 */

@Service
public class SupplierServiceImp implements SupplierService {

    private final SupplierRespository supplierRespository;
    private ModelParser modelParser;

    @Autowired
    public SupplierServiceImp(SupplierRespository carRespository, ModelParser modelParser) {
        this.supplierRespository = carRespository;
        this.modelParser = modelParser;
    }

    @Override
    public List<SupplierViewDto> getSupliers(String type) {
        if (type.equals("local")) {
            return this.modelParser.map(this.supplierRespository.getSuppliers(false), SupplierViewDto.class);
        }
        if (type.equals("importers")) {
            return this.modelParser.map(this.supplierRespository.getSuppliers(true), SupplierViewDto.class);
        }
        throw new IllegalArgumentException("Unnsuported method");
    }
}
