package com.vic.ecommerce.customer.Dtos;

import com.vic.ecommerce.customer.model.Address;

public record CustomerResponse(
    String id,
    String firstname,
    String lastname,
    String email,
    Address address
) {

}
