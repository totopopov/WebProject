package softuni.org.project00.app.models.dtos.view;

import softuni.org.project00.app.models.entities.Car;
import softuni.org.project00.app.models.entities.Customer;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Todor Popov using Lenovo on 5.3.2018 г. at 15:54.
 */

public class SaleViewDto {

    private Long id;
    private Double discount;
    private Car car;
    private Customer customer;

    public SaleViewDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
