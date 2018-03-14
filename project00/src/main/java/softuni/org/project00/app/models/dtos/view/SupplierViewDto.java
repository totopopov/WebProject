package softuni.org.project00.app.models.dtos.view;

import org.springframework.stereotype.Component;

/**
 * Created by Todor Popov using Lenovo on 8.3.2018 г. at 23:18.
 */

@Component
public class SupplierViewDto {
    private Long id;
    private String name;
    private Integer partsSize;

    public SupplierViewDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Integer getPartsSize() {
        return partsSize;
    }

    public void setPartsSize(Integer partsSize) {
        this.partsSize = partsSize;
    }
}
