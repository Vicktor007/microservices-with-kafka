package com.vic.ecommerce.CustomerClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(
        name = "customer-microservice",
        url = "${application.config.customer-url}"
)
public interface CustomerClient {

    @GetMapping("/find-customer-by-id/{customer-id}")
    Optional<CustomerResponse> findCustomerById(@PathVariable("customer-id") String customerId
    );
}
