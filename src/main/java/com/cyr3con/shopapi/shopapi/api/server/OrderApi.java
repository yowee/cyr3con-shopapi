package com.cyr3con.shopapi.shopapi.api.server;

import com.cyr3con.shopapi.shopapi.command.service.OrderCommandService;
import com.cyr3con.shopapi.shopapi.domain.Order;
import io.swagger.v3.oas.annotations.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderApi {

    @Autowired
    OrderCommandService orderService;
    final Logger log = LoggerFactory.getLogger(OrderApi.class);

    @PostMapping(value = "",consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Placing Place", description = "<p>This sample Order API will return order summary if the user input is correct</p>")
    public ResponseEntity<Order> create(@RequestBody Order order){
        log.debug("Placing Order...");
       return ResponseEntity.ok().body(orderService.save(order));
    }
}
