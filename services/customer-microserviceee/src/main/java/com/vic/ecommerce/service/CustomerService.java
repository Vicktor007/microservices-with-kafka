package com.vic.ecommerce.service;

import com.vic.ecommerce.DTO.CustomerDto;
import com.vic.ecommerce.exceptions.CustomerNotFoundException;
import com.vic.ecommerce.exceptions.OurException;
import com.vic.ecommerce.mappers.CustomerMapper;
import com.vic.ecommerce.model.Customer;
import com.vic.ecommerce.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;



    public CustomerDto createCustomer(Customer customer) {
        try {
            if (customerRepository.existsByEmail(customer.getEmail())) {
                throw new OurException(customer.getEmail() + " already exists");
            }
            Customer savedCustomer = customerRepository.save(customer);
            return CustomerMapper.mapCustomerEntityToCustomerDTO(savedCustomer);
        } catch (OurException e) {
            throw new OurException("Unable to save customer: " + e.getMessage());
        }
    }

    public List<CustomerDto> findAllCustomers(){
        try {
            List<Customer> customerList =  customerRepository.findAll();
            return CustomerMapper.mapCustomerListEntityToCustomerListDto(customerList);

        } catch (OurException e) {
            throw new OurException("Unable to get customers: " + e.getMessage());
        }
    }

    public Boolean existsById(String customerId){
        return customerRepository.findById(customerId)
                .isPresent();
    }

    public Optional<CustomerDto> findById(String customerId) {
        try {
            Optional<Customer> customerOptional = customerRepository.findById(customerId);
            if (customerOptional.isPresent()) {
                Customer customer = customerOptional.get();
                CustomerDto customerDto = CustomerMapper.mapCustomerEntityToCustomerDTO(customer);
                return Optional.of(customerDto);
            } else {
                return Optional.empty();
            }
        } catch (Exception e) {
            throw new CustomerNotFoundException("Unable to get customer with id: %s" + customerId );
        }
    }

    public void deleteCustomer(String customerId){
        try {
            customerRepository.deleteById(customerId);
        } catch (OurException e){
            throw new OurException("Unable to delete customer: " + e.getMessage());
        }
    }
}
