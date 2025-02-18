package com.vic.ecommerce.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AddressDto {
    private String street;
    private String houseNumber;
    private String zipCode;
}
