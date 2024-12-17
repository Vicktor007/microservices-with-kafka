package com.vic.ecommerce.service;

import com.vic.ecommerce.mapper.PaymentMapper;
import com.vic.ecommerce.notification.NotificationProducer;
import com.vic.ecommerce.records.PaymentNotificationRequest;
import com.vic.ecommerce.records.PaymentRequest;
import com.vic.ecommerce.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {

    @Autowired
    PaymentRepository paymentRepository;

    @Autowired
    PaymentMapper paymentMapper;

    @Autowired
    NotificationProducer notificationProducer;

    public Integer createPayment(PaymentRequest request) {
        var payment = paymentRepository.save(paymentMapper.toPayment(request));

        notificationProducer.sendNotification(
                new PaymentNotificationRequest(
                        request.orderReference(),
                        request.amount(),
                        request.paymentMethod(),
                        request.customer().firstName(),
                        request.customer().lastName(),
                        request.customer().email()
                )
        );
        return payment.getId();

    }
}
