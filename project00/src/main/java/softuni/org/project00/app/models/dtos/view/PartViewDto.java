package softuni.org.project00.app.models.dtos.view;

import org.springframework.stereotype.Component;

/**
 * Created by Todor Popov using Lenovo on 13.3.2018 г. at 23:58.
 */

@Component
public class PartViewDto {
    private String name;
    private Double price;

    public PartViewDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
