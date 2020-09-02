package com.cyr3con.shopapi.shopapi.query.service;


import com.cyr3con.shopapi.shopapi.domain.Product;
import com.cyr3con.shopapi.shopapi.exception.NoProduct;
import com.cyr3con.shopapi.shopapi.query.action.ProductQueryAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Component
public class ProductQueryservice {

    @Autowired
    ProductQueryAction productQueryAction;
    public Collection<Product> findAll() {
        return productQueryAction.findAll();
    }

    public Product saveProduct(Product product) {
        return null;
    }
    public Product getById(Integer id) throws NoProduct {
        return productQueryAction.getById(id);
    }

}
