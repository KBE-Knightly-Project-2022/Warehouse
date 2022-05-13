package knightly.spring_warehouse.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Entity
@NoArgsConstructor
@Table(name="components")

public class Component {

    @Id
    @Column
    private long id;

    @Column
    private String name;
    @Column
    private float price;
    @Column
    private String description;
    @Column
    private int attack;
    @Column
    private int defence;
    @Column
    private String position;
    @Column
    private float weight;
    @Column
    private float minrange;
    @Column
    private float maxrange;


    public Component(long id, String name, float price, String description, int attack, int defence, String position, float weight, float minrange, float maxrange) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.attack = attack;
        this.defence = defence;
        this.position = position;
        this.weight = weight;
        this.minrange = minrange;
        this.maxrange = maxrange;
    }

    @Override
    public String toString() {
        return "Component{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", attack=" + attack +
                ", defence=" + defence +
                ", position='" + position + '\'' +
                ", weight=" + weight +
                ", minr=" + minrange +
                ", maxr=" + maxrange +
                '}';
    }
}
