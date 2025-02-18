package com.vic.ecommerce.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.vic.ecommerce.model.Address;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomerDto {
    private String id;
    private String firstname;
    private String lastname;
    private String email;
    private Address address;
}
