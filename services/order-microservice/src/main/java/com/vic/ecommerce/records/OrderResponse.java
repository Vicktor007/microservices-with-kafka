package com.vic.ecommerce.records;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.vic.ecommerce.enums.PaymentMethod;

import java.math.BigDecimal;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public record OrderResponse(

        Integer id,
        String reference,
        BigDecimal amount,
        PaymentMethod paymentMethod,
        String customerId
) {
}
