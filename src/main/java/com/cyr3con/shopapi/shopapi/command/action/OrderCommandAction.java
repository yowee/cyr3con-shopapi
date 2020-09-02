package com.cyr3con.shopapi.shopapi.command.action;

import com.cyr3con.shopapi.shopapi.domain.Order;
import com.cyr3con.shopapi.shopapi.domain.OrderLine;
import com.cyr3con.shopapi.shopapi.domain.Product;
import com.cyr3con.shopapi.shopapi.exception.NotEnoghtItemsInStock;
import com.cyr3con.shopapi.shopapi.repository.OrderRepository;
import com.cyr3con.shopapi.shopapi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class OrderCommandAction {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ProductRepository productRepository;

    synchronized
    public Order save(Order order) {

        double totalPrice = calculateTotal(order.getOrderLines());
        updateStock(order.getOrderLines());
        order.setTotal(totalPrice);

        return orderRepository.addOrder(order);
    }


    public Order getOrderByBuyerId(Long id) {
        return null;
    }

    public List<Order> getOrderHistoryByBuyerId(Long id) {
        return null;
    }

    public void cancelOrderById(Long orderId) {

    }

    public int updateOrderStatusByOrderId(Long orderId, String status) {
        return 0;
    }

    public Order getOrderById(Long id) {
        return null;
    }

    public boolean validateOrder(OrderLine orderLine,Product product){
            if(product.getStock()<orderLine.getQuantity())
                throw new NotEnoghtItemsInStock("not enough items in the stock");
        return true;
    }
    public double calculateTotal(List<OrderLine> orderLineList) {
        double total=0;
        for(OrderLine orderlLine: orderLineList){
            Product product = productRepository.getById(orderlLine.getProductId());
            if(validateOrder(orderlLine,product)){
                total = total+ (orderlLine.getQuantity()*product.getPrice());
            }
        }

        return  total;
    }
    private void updateStock(List<OrderLine> orderLineList){
        for(OrderLine orderLine: orderLineList){
            Product product = productRepository.getById(orderLine.getProductId());
            product.setStock(product.getStock()-orderLine.getQuantity());
        }
    }
}
