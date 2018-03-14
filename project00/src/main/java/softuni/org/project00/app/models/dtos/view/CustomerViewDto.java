package softuni.org.project00.app.models.dtos.view;

import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by Todor Popov using Lenovo on 8.3.2018 г. at 23:18.
 */

@Component
public class CustomerViewDto {
    private String name;
    private Date birthDate;
    private Boolean YoungDriver;

    public CustomerViewDto() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return this.birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Boolean isYoungDriver() {
        return this.YoungDriver;
    }

    public void setYoungDriver(Boolean youngDriver) {
        this.YoungDriver = youngDriver;
    }
}
