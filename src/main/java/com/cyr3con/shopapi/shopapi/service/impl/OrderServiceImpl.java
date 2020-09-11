package com.cyr3con.shopapi.shopapi.service.impl;

import com.cyr3con.shopapi.shopapi.dataloader.DataLoader;
import com.cyr3con.shopapi.shopapi.domain.Item;
import com.cyr3con.shopapi.shopapi.domain.Order;
import com.cyr3con.shopapi.shopapi.domain.OrderLine;
import com.cyr3con.shopapi.shopapi.domain.dto.OrderSummary;
import com.cyr3con.shopapi.shopapi.exception.NotEnoghtItemsInStock;
import com.cyr3con.shopapi.shopapi.repository.ItemRepository;
import com.cyr3con.shopapi.shopapi.repository.OrderRepository;
import com.cyr3con.shopapi.shopapi.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class OrderServiceImpl implements OrderService {

    private static final Logger LOG = LoggerFactory.getLogger(DataLoader.class);

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public OrderSummary save(Order order) {

        double totalPrice = getTotalPrice(order.getOrderLineList());

        updateItemQuantity(order.getOrderLineList());

        order.setTotal(totalPrice);

        return new OrderSummary(orderRepository.addOrder(order));
    }


    public double getTotalPrice(Set<OrderLine> orderLineList) {
        double totalPrice = 0;

        for (OrderLine orderLine : orderLineList) {
            Item item = itemRepository.findById(orderLine.getItem().getId());

            validateOrder(orderLine.getQuantity(), item.getQuantity());
            orderLine.setItem(item);
            orderLine.updateTotalPrice();

            totalPrice += orderLine.getTotal();

        }
        return totalPrice;
    }


    private void updateItemQuantity(Set<OrderLine> orderLineList) {

        for (OrderLine orderLine : orderLineList) {
            long id = orderLine.getItem().getId();
            int quantity = orderLine.getQuantity();

            itemRepository.decreaseItemQuantity(id, quantity);
        }

    }

    public boolean validateOrder(Integer orderQuantity, Integer itemQuantity) {
        if (itemQuantity < orderQuantity || orderQuantity <= 0)

            throw new NotEnoghtItemsInStock("not enough items in the stock");
        return true;
    }
}
