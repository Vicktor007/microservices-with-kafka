package com.vic.ecommerce.service.interfacee;

import com.vic.ecommerce.DTO.Response;
import com.vic.ecommerce.model.Customer;

public interface customerInterface {

    Response createCustomer(Customer customer);

    Response findById(String customerId);

    Response existsById(String customerId);

    Response findAllCustomers();

    Response deleteCustomer(String customerId);
}