package com.cyr3con.shopapi.shopapi.query.action;


import com.cyr3con.shopapi.shopapi.domain.Product;
import com.cyr3con.shopapi.shopapi.exception.NoProduct;
import com.cyr3con.shopapi.shopapi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class ProductQueryAction {

    @Autowired
    ProductRepository productRepository;

    public Collection<Product> findAll() {
        return productRepository.findAll();
    }
    public Product getById(Integer id) throws NoProduct {
        return productRepository.getById(id);
    }
}
