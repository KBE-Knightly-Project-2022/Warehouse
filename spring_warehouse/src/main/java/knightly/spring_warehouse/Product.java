package knightly.spring_warehouse;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@NoArgsConstructor
@Table(name="products")
@Getter
public class Product {

    @Id
    @Column
    private long id;
    @Column
    private String name;
    @Column
    private String components;

    public Product(long id, String name, String compoenents) {
        this.id = id;
        this.name = name;
        this.components = compoenents;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", components='" + components + '\'' +
                '}';
    }

}
