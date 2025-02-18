package com.vic.products_microservice.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Data
@Builder
@Entity
public class Category {

    // Getters and setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;

    @OneToMany(mappedBy = "category", cascade = CascadeType.REMOVE)
    private List<Product> products;


}
