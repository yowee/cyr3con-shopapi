package com.cyr3con.shopapi.shopapi.domain.dto;

import com.cyr3con.shopapi.shopapi.domain.Order;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class OrderSummary implements Serializable {
    private Order order;

}
