package com.vic.ecommerce.controller;

import com.vic.ecommerce.DTO.CustomerDto;
import com.vic.ecommerce.DTO.Response;
import com.vic.ecommerce.model.Customer;
import com.vic.ecommerce.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping
    public ResponseEntity<Response> createCustomer(
            @RequestBody @Valid Customer customer
    ){
        Response response = customerService.createCustomer(customer);
        return ResponseEntity.status(200).body(response);
    }

//    @GetMapping
//    public ResponseEntity<List<CustomerDto>> findAll(){
//        List<CustomerDto> customers = customerService.findAllCustomers();
//        return ResponseEntity.ok(customers);
//    }
//
//    @GetMapping("/exists/{customer-id}")
//    public ResponseEntity<Boolean> existsById(
//            @PathVariable("customer-id") String customerId
//    ){
//        Boolean exists = customerService.existsById(customerId);
//        return ResponseEntity.ok(exists);
//    }
//
//    @GetMapping("/find-customer-by-id/{customer-id}")
//    public ResponseEntity<CustomerDto> findById(
//            @PathVariable("customer-id") String customerId
//    ){
//        Optional<CustomerDto> customerDto = customerService.findById(customerId);
//        return customerDto.map(ResponseEntity::ok)
//                .orElseGet(() -> ResponseEntity.notFound().build());
//    }

    @DeleteMapping("/{customer-id}")
    public ResponseEntity<Void> deleteCustomer(
            @PathVariable("customer-id") String customerId
    ) {
        customerService.deleteCustomer(customerId);
        return ResponseEntity.accepted().build();
    }
}
