package com.vic.notification_microservice.model;

import com.vic.notification_microservice.enums.NotificationType;
import com.vic.notification_microservice.records.OrderConfirmation;
import com.vic.notification_microservice.records.PaymentConfirmation;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
public class Notification {

    @Id
    private String id;
    private NotificationType type;
    private LocalDateTime notificationDate;
    private OrderConfirmation orderConfirmation;
    private PaymentConfirmation paymentConfirmation;

    // Private constructor to enforce the use of the builder
    private Notification(Builder builder) {
        this.id = builder.id;
        this.type = builder.type;
        this.notificationDate = builder.notificationDate;
        this.orderConfirmation = builder.orderConfirmation;
        this.paymentConfirmation = builder.paymentConfirmation;
    }

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public NotificationType getType() {
        return type;
    }

    public void setType(NotificationType type) {
        this.type = type;
    }

    public LocalDateTime getNotificationDate() {
        return notificationDate;
    }

    public void setNotificationDate(LocalDateTime notificationDate) {
        this.notificationDate = notificationDate;
    }

    public OrderConfirmation getOrderConfirmation() {
        return orderConfirmation;
    }

    public void setOrderConfirmation(OrderConfirmation orderConfirmation) {
        this.orderConfirmation = orderConfirmation;
    }

    public PaymentConfirmation getPaymentConfirmation() {
        return paymentConfirmation;
    }

    public void setPaymentConfirmation(PaymentConfirmation paymentConfirmation) {
        this.paymentConfirmation = paymentConfirmation;
    }

    // Static inner Builder class
    public static class Builder {
        private String id;
        private NotificationType type;
        private LocalDateTime notificationDate;
        private OrderConfirmation orderConfirmation;
        private PaymentConfirmation paymentConfirmation;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder type(NotificationType type) {
            this.type = type;
            return this;
        }

        public Builder notificationDate(LocalDateTime notificationDate) {
            this.notificationDate = notificationDate;
            return this;
        }

        public Builder orderConfirmation(OrderConfirmation orderConfirmation) {
            this.orderConfirmation = orderConfirmation;
            return this;
        }

        public Builder paymentConfirmation(PaymentConfirmation paymentConfirmation) {
            this.paymentConfirmation = paymentConfirmation;
            return this;
        }

        public Notification build() {
            return new Notification(this);
        }
    }
}
