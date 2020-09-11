package com.cyr3con.shopapi.shopapi.service;


import com.cyr3con.shopapi.shopapi.domain.Item;

import java.util.Collection;


public interface ItemService {

    Collection<Item> findAll();

    void save(Item item);

    Item getById(Long id);

    int count();
}
