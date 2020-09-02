package com.cyr3con.shopapi.shopapi.domain.pojo;

import lombok.*;

@Data
public class OrderPOJO {

    private Long orderId;
    private String productName;
    private Double price;
    private String oderStatus;
    private Long productId;
    private String category;

}
