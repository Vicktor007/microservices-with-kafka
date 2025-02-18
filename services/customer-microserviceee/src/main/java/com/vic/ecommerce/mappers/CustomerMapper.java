package com.vic.ecommerce.mappers;

import com.vic.ecommerce.DTO.CustomerDto;
import com.vic.ecommerce.model.Customer;

import java.util.List;
import java.util.stream.Collectors;

public class CustomerMapper {

    public static CustomerDto mapCustomerEntityToCustomerDTO(Customer customer) {
        CustomerDto customerDto = new CustomerDto();

        customerDto.setId(customer.getId());
        customerDto.setFirstname(customer.getFirstname());
        customerDto.setLastname(customerDto.getLastname());
        customerDto.setEmail(customer.getEmail());
        customerDto.setAddress(customer.getAddress());

        return customerDto;
    }

    public static List<CustomerDto> mapCustomerListEntityToCustomerListDto(List<Customer> customerList){
        return customerList.stream().map(CustomerMapper::mapCustomerEntityToCustomerDTO).collect(Collectors.toList());
    }
}
