package softuni.org.project00.app.models.entities;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Todor Popov using Lenovo on 5.3.2018 г. at 15:40.
 */


@Entity
@Table(name = "suppliers")
public class Supplier {

    private Long id;
    private String name;
    private Boolean isImporter;
    private Set<Part> parts;

    public Supplier() {
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

    @Column(name = "is_importer")
    public Boolean isImporter() {
        return this.isImporter;
    }

    public void setImporter(Boolean importer) {
        this.isImporter = importer;
    }

    @OneToMany(mappedBy = "supplier")
    public Set<Part> getParts() {
        return this.parts;
    }

    public void setParts(Set<Part> parts) {
        this.parts = parts;
    }
}
