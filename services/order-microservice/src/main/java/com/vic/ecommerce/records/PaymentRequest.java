package com.vic.ecommerce.records;

import com.vic.ecommerce.CustomerClient.CustomerResponse;
import com.vic.ecommerce.enums.PaymentMethod;

import java.math.BigDecimal;

public record PaymentRequest(
        BigDecimal amount,
        PaymentMethod paymentMethod,
        Integer orderId,
        String orderReference,
        CustomerResponse customer
) {
}
