package org.zero.ds3.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "city")
@Setter
@Getter
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @Column(name = "foundation_year")
    private Short foundationYear;

    @Override
    public String toString() {
        return "id: " + id +
                ", name: " + name + "\n" +
                "foundationYear: " + foundationYear +
                ", area: " + area + "km²";
    }

    private Short area;
}
