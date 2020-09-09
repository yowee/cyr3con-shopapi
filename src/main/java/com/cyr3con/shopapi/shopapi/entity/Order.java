package com.cyr3con.shopapi.shopapi.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.beans.Transient;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Order implements Serializable {

    public Order(Long id, @Valid Address shippingAddress, @Valid Address billingAddress, @Valid List<OrderLine> orderLines, double total) {
        this.id = id;
        this.shippingAddress = shippingAddress;
        this.billingAddress = billingAddress;
        this.orderLines = orderLines;
        this.status = OrderStatus.NEW;
        this.orderDate = LocalDate.now();
    }

    @JsonInclude(value = JsonInclude.Include.NON_EMPTY)
    private Long id;

    @Valid
    private Address shippingAddress;

    @Valid
    private Address billingAddress;

    @Valid
    private List<OrderLine> orderLines = new ArrayList<>();

    @Setter(value = AccessLevel.NONE)
    private OrderStatus status;

    @Setter(value = AccessLevel.NONE)
    private final LocalDate orderDate;

    @JsonProperty(value = "total_price")
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
