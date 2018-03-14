package softuni.org.project00.app.models.dtos.view;

import org.springframework.stereotype.Component;

/**
 * Created by Todor Popov using Lenovo on 8.3.2018 г. at 23:18.
 */

@Component
public class CarIdViewDto {
    private Long id;
    private String make;
    private String model;
    private Long travelledDistance;

    public CarIdViewDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMake() {
        return this.make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Long getTravelledDistance() {
        return this.travelledDistance;
    }

    public void setTravelledDistance(Long travelledDistance) {
        this.travelledDistance = travelledDistance;
    }

    public String hasId(){
        return "/cars/"+this.id+"/parts";
    }
}
