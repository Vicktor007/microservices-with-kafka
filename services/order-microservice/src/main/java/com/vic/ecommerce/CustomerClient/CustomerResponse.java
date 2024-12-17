package com.vic.ecommerce.CustomerClient;

public record CustomerResponse(
        String id,
        String firstname,
        String lastname,
        String email
) {
}
