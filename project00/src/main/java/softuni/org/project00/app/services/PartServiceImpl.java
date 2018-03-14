package softuni.org.project00.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.org.project00.app.models.dtos.view.PartViewDto;
import softuni.org.project00.app.repositories.PartRespository;
import softuni.org.project00.app.utils.ModelParser;

import java.util.List;

/**
 * Created by Todor Popov using Lenovo on 13.3.2018 г. at 23:59.
 */

@Service
public class PartServiceImpl implements PartService{

    private final PartRespository partRespository;
    private final ModelParser modelParser;

    @Autowired
    public PartServiceImpl(PartRespository partRespository, ModelParser modelParser) {
        this.partRespository = partRespository;
        this.modelParser = modelParser;
    }

    @Override
    public List<PartViewDto> getParts(Long id) {
        return this.modelParser.map(this.partRespository.getParts(id), PartViewDto.class);
    }
}
