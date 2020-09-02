package com.cyr3con.shopapi.shopapi.repository;

import com.cyr3con.shopapi.shopapi.domain.Category;
import com.cyr3con.shopapi.shopapi.domain.Product;
import com.cyr3con.shopapi.shopapi.exception.NoProduct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class ProductRepository {
    private AtomicInteger counter = new AtomicInteger(0);
    private Map<Integer, Product> producs=new HashMap<>();
    final Logger log = LoggerFactory.getLogger(ProductRepository.class);

    public Product addProduct(Product product){
        int id = counter.incrementAndGet();
        product.setId(id);

        producs.put(id,product);
        log.debug(product.toString());
        return product;
    }

    public void initProduct(){
        addProduct(new Product(null,"Mac",2000.0,20,"this is Mac",new Category(1,"laptop","this is laptop")));
        addProduct(new Product(null,"Iphone",1000.0,10,"this is Iphone",new Category(1,"mobile","this is mobile")));
    }

    public Collection<Product> findAll() {
        return this.producs.values();
    }

    public Product getById(Integer id) {
        Product product = producs.get(id);
        if( product==null) throw new  NoProduct("Unable to find product");
    return product;
    }
}
