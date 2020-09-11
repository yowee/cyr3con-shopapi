package com.cyr3con.shopapi.shopapi.service.impl;


import com.cyr3con.shopapi.shopapi.domain.Item;
import com.cyr3con.shopapi.shopapi.repository.ItemRepository;
import com.cyr3con.shopapi.shopapi.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class ItemServiceImpl implements ItemService {

    @Autowired
    ItemRepository itemRepository;

    @Override
    public Collection<Item> findAll() {
        return itemRepository.findAll();
    }

    @Override
    public void save(Item item) {
        itemRepository.save(item);
    }

    @Override
    public Item getById(Long id) {
        return itemRepository.findById(id);
    }

    @Override
    public int count() {
        return itemRepository.count();
    }

}
