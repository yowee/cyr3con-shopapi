package com.cyr3con.shopapi.shopapi.command.service;


import com.cyr3con.shopapi.shopapi.command.action.ProductCommandAction;
import com.cyr3con.shopapi.shopapi.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductCommandService {

    @Autowired
    ProductCommandAction productCommandAction;

    public Product saveProduct(Product product) {
        return null;
    }

    public void deleteProductById(Long id) {

    }
}
