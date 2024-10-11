package org.zero.ds3.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "resident")
@Getter
@Setter
public class Resident {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "language")
    private Language language;

    @Override
    public String toString() {
        return
                "id: " + id +
                ", name: " + name + '\n' +
                "language: " + language +
                ", city: " + city.getName();
    }

    @ManyToOne
    @JoinColumn(name = "city")
    private City city;
}
