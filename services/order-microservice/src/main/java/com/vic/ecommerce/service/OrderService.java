package com.vic.ecommerce.service;

import com.vic.ecommerce.CustomerClient.CustomerClient;
import com.vic.ecommerce.OrderRepository.OrderRepository;
import com.vic.ecommerce.PaymentClient.PaymentClient;
import com.vic.ecommerce.ProductClient.ProductClient;
import com.vic.ecommerce.exception.BusinessException;
import com.vic.ecommerce.kafka.OrderProducer;
import com.vic.ecommerce.mapper.OrderMapper;
import com.vic.ecommerce.records.*;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    CustomerClient customerClient;

    @Autowired
    ProductClient productClient;

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    OrderLineService orderLineService;

    @Autowired
    OrderProducer orderProducer;

    @Autowired
    PaymentClient paymentClient;

    @Transactional
    public Integer createOrder(OrderRequest request) {
        var customer = this.customerClient.findCustomerById(request.customerId())
                .orElseThrow(()-> new BusinessException("Cannot create order; No customer with the provided ID"));

        var purchasedProducts = productClient.purchaseProducts(request.products());

        var order = this.orderRepository.save(orderMapper.toOrder(request));

        for(ProductPurchaseRequest purchaseRequest: request.products() ){
            orderLineService.saveOrderLine(
                    new OrderLineRequest(
                            null,
                            order.getId(),
                            purchaseRequest.productId(),
                            purchaseRequest.quantity()
                    )
            );
        }
                var paymentRequest = new PaymentRequest(
                        request.amount(),
                        request.paymentMethod(),
                        order.getId(),
                        order.getReference(),
                        customer
                );
                paymentClient.requestOrderPayment(paymentRequest);

        orderProducer.sendOrderConfirmation(
                new OrderConfirmation(
                        request.reference(),
                        request.amount(),
                        request.paymentMethod(),
                        customer,
                        purchasedProducts
                )
        );
        return order.getId();

    }

    public OrderResponse findById(Integer orderId) {
        return this.orderRepository.findById(orderId)
                .map(this.orderMapper::fromOrder)
                .orElseThrow(()-> new EntityNotFoundException(String.format("No order found with the provided ID: %d", orderId)));
    }

    public List<OrderResponse> findAllOrders() {
        return this.orderRepository.findAll()
                .stream()
                .map(this.orderMapper::fromOrder)
                .collect(Collectors.toList());
    }
}
