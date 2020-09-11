package com.cyr3con.shopapi.shopapi.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Order {

    public Order(Set<OrderLine> orderLineList) {
        this.orderLineList = orderLineList;
    }

    @JsonInclude(value = JsonInclude.Include.NON_EMPTY)
    private Integer id;
    @Valid
    @JsonProperty(value = "ordered_items")
    private Set<OrderLine> orderLineList;
    private final LocalDate orderDate = LocalDate.now();
    @JsonProperty(value = "total_price")
    private double total;

}
