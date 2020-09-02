package com.cyr3con.shopapi.shopapi.domain;

import lombok.*;

import javax.validation.Valid;
import java.beans.Transient;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Data
public class Order implements Serializable {

    private Long id;
    @Valid
    private Address shippingAddress;
    @Valid
    private Address billingAddress;
    private List<OrderLine> orderLines = new ArrayList<>();
    private OrderStatus status = OrderStatus.NEW;
    private double total;

    @Transient
    public Double getTotalPrice() {
        double sum = 0D;
        List<OrderLine> orderLines = getOrderLines();
        for (OrderLine ol : orderLines) {
            sum += ol.getTotalPrice();
        }
        return sum;
    }

    @Transient
    public int getNumberOfProducts() {
        return this.orderLines.size();
    }
}
