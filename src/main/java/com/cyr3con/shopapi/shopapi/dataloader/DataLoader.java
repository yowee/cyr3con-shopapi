package com.cyr3con.shopapi.shopapi.dataloader;

import com.cyr3con.shopapi.shopapi.domain.Item;
import com.cyr3con.shopapi.shopapi.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;


@Component
public class DataLoader {
    @Autowired
    private ItemService itemService;
    private static final Logger LOG = LoggerFactory.getLogger(DataLoader.class);


    @EventListener(ApplicationReadyEvent.class)
    public void populateData() {
        itemService.save(new Item(1l,"nike",1000.0,10));
        itemService.save(new Item(2l,"puma",1000.0,20));

        LOG.info("Saved dummy Item data : {}", itemService.count());
    }

}