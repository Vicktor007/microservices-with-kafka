package com.vic.ecommerce.mapper;


import com.vic.ecommerce.model.Order;
import com.vic.ecommerce.model.OrderLine;
import com.vic.ecommerce.records.OrderLineRequest;
import com.vic.ecommerce.records.OrderLineResponse;
import org.springframework.stereotype.Service;

@Service
public class OrderLineMapper {
    public OrderLine toOrderLine(OrderLineRequest orderLineRequest) {
        return new OrderLine.Builder()
                .id(orderLineRequest.orderId())
                .productId(orderLineRequest.productId())
                .order(
                       new Order.Builder()
                                .id(orderLineRequest.orderId())
                                .build()
                )
                .quantity(orderLineRequest.quantity())
                .build();
    }

    public OrderLineResponse toOrderLineResponse(OrderLine orderLine){
        return new OrderLineResponse(
                orderLine.getId(),
                orderLine.getQuantity()
        );
    }
}
