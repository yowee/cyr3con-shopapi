package com.cyr3con.shopapi.shopapi.repository;

import com.cyr3con.shopapi.shopapi.domain.Order;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Data
@Repository
public class OrderRepository {
    private List<Order> orderList = new ArrayList<>();

    public Order addOrder(Order order) {
        orderList.add(order);
        return order;
    }


}
