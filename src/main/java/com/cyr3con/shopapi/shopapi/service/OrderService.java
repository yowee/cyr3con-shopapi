package com.cyr3con.shopapi.shopapi.service;

import com.cyr3con.shopapi.shopapi.domain.Order;
import com.cyr3con.shopapi.shopapi.domain.dto.OrderSummary;


public interface OrderService {
    OrderSummary save(Order order);
}
