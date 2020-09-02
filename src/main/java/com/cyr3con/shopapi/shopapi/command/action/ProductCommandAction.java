package com.cyr3con.shopapi.shopapi.command.action;


import com.cyr3con.shopapi.shopapi.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductCommandAction{

    @Autowired
    ProductCommandAction productCommandAction;

    public Product saveProduct(Product product) {
        return null;
    }

    public void deleteProductById(Long id) {

    }

}
