package softuni.org.project00.app.services;

import softuni.org.project00.app.models.dtos.view.PartViewDto;

import java.util.List;

/**
 * Created by Todor Popov using Lenovo on 13.3.2018 г. at 23:59.
 */
public interface PartService {
    List<PartViewDto> getParts(Long id);
}
