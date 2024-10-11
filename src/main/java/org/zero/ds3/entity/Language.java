package org.zero.ds3.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "language")
@Getter
@Setter
public class Language {
    @Id
    private Integer id;
    private String title;

    @Override
    public String toString() {
        return title;
    }
}
