package com.vic.ecommerce.mapper;

import com.vic.ecommerce.model.Payment;
import com.vic.ecommerce.records.PaymentRequest;
import org.springframework.stereotype.Service;

@Service
public class PaymentMapper {
    public Payment toPayment(PaymentRequest request) {
        if (request == null){
            return null;
        }
        return new Payment.Builder()
                .id(request.id())
                .orderId(request.orderId())
                .paymentMethod(request.paymentMethod())
                .amount(request.amount())
                .build();
    }
}
