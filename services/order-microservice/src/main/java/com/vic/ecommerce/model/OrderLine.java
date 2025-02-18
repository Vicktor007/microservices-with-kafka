package com.vic.ecommerce.model;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "customer_line")
public class OrderLine {

    public OrderLine() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
    private Integer productId;
    private double quantity;



}
