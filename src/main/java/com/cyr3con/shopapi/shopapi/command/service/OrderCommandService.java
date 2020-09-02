package com.cyr3con.shopapi.shopapi.command.service;
import com.cyr3con.shopapi.shopapi.command.action.OrderCommandAction;
import com.cyr3con.shopapi.shopapi.command.action.ProductCommandAction;
import com.cyr3con.shopapi.shopapi.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderCommandService {

    @Autowired
    private OrderCommandAction orderCommandAction;
    @Autowired
    private ProductCommandAction productCommandAction;


    public Order save(Order order) {
       return orderCommandAction.save(order);
    }


    public Order getOrderByBuyerId(Long id) {
        return null;
    }

    public List<Order> getOrderHistoryByBuyerId(Long id) {
        return null;
    }

    public void cancelOrderById(Long orderId) {    }

    public int updateOrderStatusByOrderId(Long orderId, String status) {
        return 0;
    }

    public Order getOrderById(Long id) {
        return null;
    }

}
