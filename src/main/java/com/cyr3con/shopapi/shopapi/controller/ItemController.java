package com.cyr3con.shopapi.shopapi.controller;

import com.cyr3con.shopapi.shopapi.domain.Item;
import com.cyr3con.shopapi.shopapi.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/items")
public class ItemController{

    @Autowired
    ItemService itemService;

    @GetMapping
    public ResponseEntity<Collection<Item>> getCurrentItemQuantity() {
        return ResponseEntity.ok().body(itemService.findAll());
    }

}
