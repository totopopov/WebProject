package softuni.org.project00.app.models.entities;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Todor Popov using Lenovo on 5.3.2018 г. at 16:03.
 */

@Entity
@Table(name = "parts")
public class Part {

    private Long id;
    private String name;
    private Double price;
    private Long quantity;
    private Supplier supplier;
    private Set<Car> cars;

    public Part() {
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

    public Double getPrice() {
        return this.price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    public Supplier getSupplier() {
        return this.supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    @ManyToMany
    @JoinTable(name = "parts_cars",
            joinColumns = {@JoinColumn(name = "part_id",referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "car_id",referencedColumnName = "id")})
    public Set<Car> getCars() {
        return this.cars;
    }

    public void setCars(Set<Car> cars) {
        this.cars = cars;
    }
}

