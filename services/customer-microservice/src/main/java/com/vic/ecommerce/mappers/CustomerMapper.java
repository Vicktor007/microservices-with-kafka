package com.vic.ecommerce.mappers;

import com.vic.ecommerce.customer.Customer;
import com.vic.ecommerce.records.CustomerRequest;
import com.vic.ecommerce.records.CustomerResponse;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

@Service
public class CustomerMapper {
    public Customer toCustomer(@Valid CustomerRequest request) {
        return  new Customer.Builder()
                .id(request.id())
                .firstname(request.firstname())
                .lastname(request.lastname())
                .email(request.email())
                .address(request.address())
                .build();
    }

    public CustomerResponse fromCustomer(Customer customer) {
            return new CustomerResponse(
                    customer.getId(),
                    customer.getFirstname(),
                    customer.getLastname(),
                    customer.getEmail(),
                    customer.getAddress()
            );
    }
}
