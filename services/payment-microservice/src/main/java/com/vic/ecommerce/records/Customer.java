package com.vic.ecommerce.records;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

@Validated
public record Customer(
        String id,

        @NotNull(message = "firstName is required")
        String firstName,
        @NotNull(message = "lastName is required")
        String lastName,
        @NotNull(message = "email is required")
        @Email(message = "the customer is not correctly formatted")
        String email
) {
}
