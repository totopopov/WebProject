package softuni.org.project00.app.models.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created by Todor Popov using Lenovo on 5.3.2018 г. at 15:45.
 */

@Entity
@Table(name = "customers")
public class Customer {

    private Long id;
    private String name;
    private Date birthDate;
    private Boolean isYoungDriver;
    private Set<Sale> sales;

    public Customer() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "birth_date", columnDefinition="DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getBirthDate() {
        return this.birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Column(name = "is_young_driver")
    public Boolean isYoungDriver() {
        return this.isYoungDriver;
    }

    public void setYoungDriver(Boolean youngDriver) {
        this.isYoungDriver = youngDriver;
    }

    @OneToMany(mappedBy = "customer")
    public Set<Sale> getSales() {
        return this.sales;
    }

    public void setSales(Set<Sale> sales) {
        this.sales = sales;
    }
}
