package com.vic.ecommerce.records;



public record OrderLineRequest( Integer id,
                                Integer orderId,
                                Integer productId,
                                double quantity) {
}
