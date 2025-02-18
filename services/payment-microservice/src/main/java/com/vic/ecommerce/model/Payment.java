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

import static jakarta.persistence.EnumType.STRING;

@Setter
@Getter
@Entity
@Data
@Builder
@EntityListeners(AuditingEntityListener.class)
@Table(name = "payment")
public class Payment {

    // Getters and setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private BigDecimal amount;

    @Enumerated(STRING)
    private PaymentMethod paymentMethod;
    private Integer orderId;

    @CreatedDate
    @Column(updatable = false, nullable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(insertable = false)
    private LocalDateTime lastModifiedDate;


}
