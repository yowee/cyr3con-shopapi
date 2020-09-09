package com.cyr3con.shopapi.shopapi.api.server;

import com.cyr3con.shopapi.shopapi.entity.Product;
import com.cyr3con.shopapi.shopapi.query.service.ProductQueryservice;
import io.swagger.v3.oas.annotations.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/product")
public class ProductApi {
    @Autowired
    ProductQueryservice productService;
    final Logger log = LoggerFactory.getLogger(ProductApi.class);

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Retrieve Products", description = "<p>This Product API will return Products along with their details</p>")
    public ResponseEntity<Collection<Product>> getCurrentItemQuantity() {

        log.debug("getting product details.");
        return ResponseEntity.ok().body(productService.findAll());
    }

}
