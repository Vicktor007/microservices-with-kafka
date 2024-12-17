package com.vic.ecommerce.controller;


import com.vic.ecommerce.records.OrderRequest;
import com.vic.ecommerce.records.OrderResponse;
import com.vic.ecommerce.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {
        @Autowired
         OrderService orderService;

        @PostMapping
    public ResponseEntity<Integer> createOrder(
            @RequestBody @Valid OrderRequest request
        ){
            return ResponseEntity.ok(this.orderService.createOrder(request));
        }

        @GetMapping("/{order-id}")
    public ResponseEntity<OrderResponse> findById(
            @PathVariable("order-id") Integer orderId
        ) {
            return ResponseEntity.ok(this.orderService.findById(orderId));
        }

        @GetMapping
    public ResponseEntity<List<OrderResponse>> findAll(){
            return ResponseEntity.ok(this.orderService.findAllOrders());
        }
}

