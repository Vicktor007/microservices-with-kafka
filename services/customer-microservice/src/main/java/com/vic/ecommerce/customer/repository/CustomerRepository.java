package com.vic.ecommerce.customer.repository;

import com.vic.ecommerce.customer.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, String > {

}
