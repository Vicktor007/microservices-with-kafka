package com.vic.ecommerce.records;

import com.vic.ecommerce.enums.PaymentMethod;

import java.math.BigDecimal;

public record PaymentNotificationRequest(
        String orderReference,
        BigDecimal amount,
        PaymentMethod paymentMethod,

        String customerFirstName,
        String customerLastName,
        String CustomerEmail
) {
}
