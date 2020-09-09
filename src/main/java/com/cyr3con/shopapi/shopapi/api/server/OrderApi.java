package com.cyr3con.shopapi.shopapi.api.server;

import com.cyr3con.shopapi.shopapi.command.service.OrderCommandService;
import com.cyr3con.shopapi.shopapi.entity.Order;
import io.swagger.v3.oas.annotations.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderApi {

    @Autowired
    OrderCommandService orderService;
    final Logger log = LoggerFactory.getLogger(OrderApi.class);

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Placing Order", description = "<p>This Order API accept Order object and return order summary if the user input is correct</p>")
    public ResponseEntity<Order> create(@Valid @RequestBody Order order) {
        log.debug("Placing Order");
        return ResponseEntity.ok().body(orderService.save(order));
    }
}
