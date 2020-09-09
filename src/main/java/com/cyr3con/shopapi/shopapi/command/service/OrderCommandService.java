package com.cyr3con.shopapi.shopapi.command.service;
import com.cyr3con.shopapi.shopapi.command.action.OrderCommandAction;
import com.cyr3con.shopapi.shopapi.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderCommandService {

    @Autowired
    private OrderCommandAction orderCommandAction;

    public Order save(Order order) {
       return orderCommandAction.save(order);
    }


}
