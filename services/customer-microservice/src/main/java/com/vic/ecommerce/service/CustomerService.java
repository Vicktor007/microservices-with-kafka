package com.vic.ecommerce.service;

import com.vic.ecommerce.customer.Customer;
import com.vic.ecommerce.exceptions.CustomerNotFoundException;
import com.vic.ecommerce.mappers.CustomerMapper;
import com.vic.ecommerce.records.CustomerRequest;
import com.vic.ecommerce.records.CustomerResponse;
import com.vic.ecommerce.repository.CustomerRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerService {

    @Autowired
     CustomerRepository customerRepository;

    @Autowired
     CustomerMapper customerMapper;

    public String createCustomer(@Valid CustomerRequest request) {
        var customer = customerRepository.save(customerMapper.toCustomer(request));
        return customer.getId();
    }

    public void updateCustomer(@Valid CustomerRequest request) {
        var customer = customerRepository.findById(request.id())
                .orElseThrow(() -> new CustomerNotFoundException(
                        String.format("Cannot update customer::No customer found with the provided ID::%s", request.id())
                ));

        mergeCustomer(customer, request);
        customerRepository.save(customer);
    }

    private void mergeCustomer(Customer customer, @Valid CustomerRequest request) {
        if (StringUtils.isNotBlank(request.firstname())){
            customer.setFirstname(request.firstname());
        }
        if (StringUtils.isNotBlank(request.lastname())){
            customer.setFirstname(request.lastname());
        }
        if (StringUtils.isNotBlank(request.email())){
            customer.setFirstname(request.email());
        }
        if (request.firstname() != null){
            customer.setAddress(request.address());
        }
    }

    public List<CustomerResponse> findAllCustomers() {
        return customerRepository.findAll()
                .stream()
                .map(customerMapper::fromCustomer)
                .collect(Collectors.toList());


    }

    public Boolean existsById(String customerId) {
       return customerRepository.findById(customerId)
                .isPresent();
    }

    public CustomerResponse findById(String customerId) {
        return customerRepository.findById(customerId)
                .map(customerMapper::fromCustomer)
                .orElseThrow(()-> new CustomerNotFoundException(
                        String.format("No customer found with the provided ID: %s", customerId)
                ));

    }

    public void deleteCustomer(String customerId) {
        customerRepository.deleteById(customerId);
    }
}
