package com.cyr3con.shopapi.shopapi.domain;

import lombok.*;

import java.beans.Transient;
import java.io.Serializable;

@Data
public class OrderLine implements Serializable {

    private Long id;
    private Integer productId;
    private Integer quantity;


    @Transient
    public Double getTotalPrice() {
        return null;
    }
}
