package com.vic.ecommerce.service;

import com.vic.ecommerce.OrderRepository.OrderLineRepository;
import com.vic.ecommerce.exception.BusinessException;
import com.vic.ecommerce.mapper.OrderLineMapper;
import com.vic.ecommerce.records.OrderLineRequest;
import com.vic.ecommerce.records.OrderLineResponse;
import jakarta.persistence.OptimisticLockException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderLineService {

    @Autowired
    OrderLineRepository orderLineRepository;

    @Autowired
    OrderLineMapper orderLineMapper;

    public Integer saveOrderLine(OrderLineRequest orderLineRequest) {
        try {
            var order = orderLineMapper.toOrderLine(orderLineRequest);
            return orderLineRepository.save(order).getId();
        } catch (OptimisticLockException e) {
            // Handle the optimistic lock exception
            throw new BusinessException("The order line was updated or deleted by another transaction.");
        }
    }

    public List<OrderLineResponse> findAllByOrderId(Integer orderId) {
        return orderLineRepository.findAllByOrderId(orderId)
                .stream()
                .map(orderLineMapper::toOrderLineResponse)
                .collect(Collectors.toList());
    }
}
