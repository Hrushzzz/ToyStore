package dev.hrushikesh.ToyStore.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

@Entity
public class Toy {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String description;
    private int manufacturedYear;
    private double price;
    private boolean inStock;

    @Version
    private Long version;
}
