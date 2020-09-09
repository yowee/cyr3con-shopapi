package com.cyr3con.shopapi.shopapi.repository;

import com.cyr3con.shopapi.shopapi.entity.Order;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Data
@Repository
public class OrderRepository {
    private AtomicInteger counter = new AtomicInteger(0);
    private Map<Integer, Order> orderList = new HashMap<>();

    /**
     * Add order to order order database
     * @param order order to be placed
     * @return Order order summary
     */
    public Order addOrder(Order order) {
        int id = counter.incrementAndGet();
        order.setId(((long) id));
        orderList.put(id, order);

        return order;
    }


}
