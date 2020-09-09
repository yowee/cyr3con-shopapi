package com.cyr3con.shopapi.shopapi.repository;

import com.cyr3con.shopapi.shopapi.entity.CatalogComponent;
import com.cyr3con.shopapi.shopapi.entity.Category;
import com.cyr3con.shopapi.shopapi.entity.Product;
import com.cyr3con.shopapi.shopapi.entity.ProductCatalog;
import com.cyr3con.shopapi.shopapi.exception.NoProduct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class ProductRepository {
    /**
     * Atomic counter to get a thread safe product id and hashmap key
     */
    private AtomicInteger counter = new AtomicInteger(0);

    //all products will be saved here
    private Map<Integer, Product> producs = new HashMap<>();
    final Logger log = LoggerFactory.getLogger(ProductRepository.class);


    /**
     * Save a product to the db (HashMap) and change the id of the product accordingly
     *
     * @param product
     * @return Product
     */
    public Product addProduct(Product product) {
        //get the next id
        int id = counter.incrementAndGet();

        //update the product id
        product.setId(id);

        //save product to db
        producs.put(id, product);

        log.info("Save product to db {}", product.toString());

        return product;
    }


    public Collection<Product> findAll() {
        return this.producs.values();
    }


    /**
     * @param id Product id
     * @return
     */
    public Product getById(Integer id) {
        Product product = producs.get(id);
        log.info("get product by id {}", product);

        if (product == null) throw new NoProduct("Unable to find product");

        return product;
    }
}
