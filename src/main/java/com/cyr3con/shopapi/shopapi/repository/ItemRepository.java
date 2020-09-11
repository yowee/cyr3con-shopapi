package com.cyr3con.shopapi.shopapi.repository;

import com.cyr3con.shopapi.shopapi.domain.Item;
import com.cyr3con.shopapi.shopapi.exception.NoItem;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ItemRepository {

    private List<Item> items = new ArrayList<>();

    public void save(Item item) {
        items.add(item);
    }

    public Collection<Item> findAll() {
        return this.items;
    }

    public int count() {
        return items.size();
    }

    public Item findById(Long id) {
        if (id <= count() && id >= 1)
            return Optional.of(items.get(Math.toIntExact(id - 1))).orElseThrow(() -> new NoItem("Could not find an item with id: " + id));

        throw new NoItem("Could not find an item with id: " + id);
    }

    public void decreaseItemQuantity(long id, int quantity) {
        Item item = findById(id);
        item.setQuantity(item.getQuantity() - quantity);
    }
}
