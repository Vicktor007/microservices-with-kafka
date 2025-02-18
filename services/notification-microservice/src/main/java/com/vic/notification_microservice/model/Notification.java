package com.vic.notification_microservice.model;

import com.vic.notification_microservice.enums.NotificationType;
import com.vic.notification_microservice.records.OrderConfirmation;
import com.vic.notification_microservice.records.PaymentConfirmation;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Setter
@Getter
@Document
@Builder
@Data
public class Notification {


    @Id
    private String id;
    private NotificationType type;
    private LocalDateTime notificationDate;
    private OrderConfirmation orderConfirmation;
    private PaymentConfirmation paymentConfirmation;


}
