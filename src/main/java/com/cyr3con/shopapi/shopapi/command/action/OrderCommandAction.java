package com.cyr3con.shopapi.shopapi.command.action;

import com.cyr3con.shopapi.shopapi.entity.Order;
import com.cyr3con.shopapi.shopapi.entity.OrderLine;
import com.cyr3con.shopapi.shopapi.entity.Product;
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

    /**
     * order to the order db.
     */

    public Order save(Order order) {
        double totalPrice = calculateTotal(order.getOrderLines());
        updateStock(order.getOrderLines());
        order.setTotal(totalPrice);

        return orderRepository.addOrder(order);
    }


    /**
     * @param orderQuantity ordered quantity
     * @param productQuantity available product in the stock
     * @return true there is available product in the stock
     * @throws NotEnoghtItemsInStock if the orderuantity is lessthan 0 or greterthan product quantity
     */
    public boolean validateOrder(Integer orderQuantity, Integer productQuantity) {
        if (productQuantity < orderQuantity || orderQuantity<=0)
            throw new NotEnoghtItemsInStock("not enough items in the stock");
        return true;
    }

    /**
     * Calculate the total price and validate the order simultaneously
     * @param orderLineList list of order lines which holds product id and quantity
     * @return  total total price
     * @throws NotEnoghtItemsInStock order quantity grater than stock
     */
    public double calculateTotal(List<OrderLine> orderLineList) {
        double total = 0;
        for (OrderLine orderLine : orderLineList) {
            Product product = productRepository.getById(orderLine.getProductId());
            if (validateOrder(orderLine.getQuantity(), product.getStock())) {
                total = total + (orderLine.getQuantity() * product.getPrice());
            }
        }

        return total;
    }

    /**
     * Thread safe methodtod Update quantity of the product to the product database based on the quantity of the order
     * @param orderLineList list of order lines which holds product id and quantity
     */
    private void updateStock(List<OrderLine> orderLineList) {
        for (OrderLine orderLine : orderLineList) {
            Product product = productRepository.getById(orderLine.getProductId());
            product.setStock(product.getStock() - orderLine.getQuantity());
        }
    }
}
