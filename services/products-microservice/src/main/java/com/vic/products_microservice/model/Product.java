package com.vic.products_microservice.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@Data
@Builder
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;
    private double availableQuantity;
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;


}
