package com.vic.ecommerce.model;

import com.vic.ecommerce.enums.PaymentMethod;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static jakarta.persistence.EnumType.STRING;

@Setter
@Getter
@Entity
@Builder
@Data
@EntityListeners(AuditingEntityListener.class)
@Table(name = "customer_order")
public class Order {

    // Getters and setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false)
    private String reference;

    private BigDecimal totalAmount;

    @Enumerated(STRING)
    private PaymentMethod paymentMethod;

    private String customerId;

    @OneToMany(mappedBy = "order")
    private List<OrderLine> orderLines;

    @CreatedDate
    @Column(updatable = false, nullable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(insertable = false)
    private LocalDateTime lastModifiedDate;


}
