package com.cyr3con.shopapi.shopapi.controller;
import com.cyr3con.shopapi.shopapi.domain.Item;
import com.cyr3con.shopapi.shopapi.service.ItemService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;

import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringRunner.class)
@WebMvcTest(ItemController.class)
class ItemControllerTest {
    @Autowired
    private MockMvc mvc;
    @MockBean
    private ItemService service;

    @Test
    public void givenGetPath_thenReturnJsonArray()
            throws Exception {

        Item item = new Item(null,"apple",1000.0,5);

        List<Item> allItems = Arrays.asList(item);
        given(service.findAll()).willReturn(allItems);

        mvc.perform(get("/items")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].name", is(item.getName())));
    }

}