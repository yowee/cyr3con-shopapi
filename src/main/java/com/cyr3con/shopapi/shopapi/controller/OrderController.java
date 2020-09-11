package com.cyr3con.shopapi.shopapi.controller;

import com.cyr3con.shopapi.shopapi.domain.Order;
import com.cyr3con.shopapi.shopapi.domain.dto.OrderRequest;
import com.cyr3con.shopapi.shopapi.domain.dto.OrderSummary;
import com.cyr3con.shopapi.shopapi.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    OrderService orderService;


    @PostMapping
    public ResponseEntity<OrderSummary> create(@Valid @NotNull @RequestBody OrderRequest orderRequest) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(orderService.save(new Order(orderRequest.getOrderLineSet())));
    }

}
