package com.vic.notification_microservice.records;

public record Customer(
        String id,
        String firstname,
        String lastname,
        String email
) {
}
