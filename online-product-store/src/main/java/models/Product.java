package models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

public class Product {
    @Id
    @GeneratedValue
    private Long Id;

    private String name;
    private String description;
    private Float price;

    public Product(Long id, String name, String description, Float price) {
        Id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}