package com.vic.ecommerce.exceptions;

import java.util.Map;

public record ErrorResponse(
    Map<String, String> errors
) {

}
