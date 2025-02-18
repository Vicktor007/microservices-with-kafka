package com.vic.ecommerce.records;


import com.vic.ecommerce.model.Address;

public record CustomerResponse(
        String id,

        String firstname,

        String lastname,

        String email,

        Address address
) {
}
