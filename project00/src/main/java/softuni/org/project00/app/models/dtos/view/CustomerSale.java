package softuni.org.project00.app.models.dtos.view;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by Todor Popov using Lenovo on 14.3.2018 г. at 21:29.
 */
public class CustomerSale {

    private String name;
    private Long cars;
    private BigDecimal money;

    public CustomerSale() {
    }

    public CustomerSale(String name, Long cars, BigDecimal money) {
        this.name = name;
        this.cars = cars;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCars() {
        return cars;
    }

    public void setCars(Long cars) {
        this.cars = cars;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return String.format(" %s bought %d cars, spent $ %s", this.name, this.cars, this.money.setScale(2, RoundingMode.CEILING));
    }
}
