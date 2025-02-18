//
//
//package com.vic.ecommerce.service;
//
//import com.vic.ecommerce.DTO.CustomerDto;
//import com.vic.ecommerce.exceptions.CustomerNotFoundException;
//import com.vic.ecommerce.exceptions.OurException;
//import com.vic.ecommerce.mappers.CustomerMapper;
//import com.vic.ecommerce.model.Customer;
//import com.vic.ecommerce.repository.CustomerRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class CustomerService {
//
//    @Autowired
//    CustomerRepository customerRepository;
//
//    public CustomerDto createCustomer(Customer customer) {
//        if (customerRepository.existsByEmail(customer.getEmail())) {
//            throw new OurException(customer.getEmail() + " already exists");
//        }
//        Customer savedCustomer = customerRepository.save(customer);
//        return CustomerMapper.mapCustomerEntityToCustomerDTO(savedCustomer);
//    }
//
//    public List<CustomerDto> findAllCustomers() {
//        List<Customer> customerList = customerRepository.findAll();
//        return CustomerMapper.mapCustomerListEntityToCustomerListDto(customerList);
//    }
//
//    public Boolean existsById(String customerId) {
//        return customerRepository.findById(customerId).isPresent();
//    }
//
//    public Optional<CustomerDto> findById(String customerId) {
//        Optional<Customer> customerOptional = customerRepository.findById(customerId);
//        if (customerOptional.isPresent()) {
//            Customer customer = customerOptional.get();
//            CustomerDto customerDto = CustomerMapper.mapCustomerEntityToCustomerDTO(customer);
//            return Optional.of(customerDto);
//        } else {
//            return Optional.empty();
//        }
//    }
//
//    public void deleteCustomer(String customerId) {
//        try {
//            customerRepository.deleteById(customerId);
//        } catch (Exception e) {
//            throw new OurException("Unable to delete customer: " + e.getMessage());
//        }
//    }
//}

package com.vic.ecommerce.service;

import com.vic.ecommerce.DTO.CustomerDto;
import com.vic.ecommerce.DTO.Response;
import com.vic.ecommerce.exceptions.OurException;
import com.vic.ecommerce.mappers.CustomerMapper;
import com.vic.ecommerce.model.Customer;
import com.vic.ecommerce.repository.CustomerRepository;
import com.vic.ecommerce.service.interfacee.customerInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService implements customerInterface {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Response createCustomer(Customer customer) {
        Response response = new Response();
        try {
            if (customerRepository.existsByEmail(customer.getEmail())) {
                throw new OurException(customer.getEmail() + " already exists");
            }
            Customer savedCustomer = customerRepository.save(customer);
            CustomerDto customerDto = CustomerMapper.mapCustomerEntityToCustomerDTO(savedCustomer);
            response.setCustomer(customerDto);
        } catch (DataIntegrityViolationException e) {
            throw new OurException("Data integrity violation: " + e.getMessage());
        } catch (Exception e) {
            throw new OurException("Error creating customer: " + e.getMessage());
        }
        return response;
    }

    @Override
    public Response findById(String customerId) {
        return null;
    }

    @Override
    public Response existsById(String customerId) {
        return null;
    }

    @Override
    public Response findAllCustomers() {
        return null;
    }

    @Override
    public Response deleteCustomer(String customerId) {
        return null;
    }
}