package com.cyr3con.shopapi.shopapi.controller;

import com.cyr3con.shopapi.shopapi.api.server.ProductApi;
import com.cyr3con.shopapi.shopapi.entity.Category;
import com.cyr3con.shopapi.shopapi.entity.Product;
import com.cyr3con.shopapi.shopapi.query.service.ProductQueryservice;
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
@WebMvcTest(ProductApi.class)
class ProductApiTest {
    @Autowired
    private MockMvc mvc;
    @MockBean
    private ProductQueryservice service;

    @Test
    public void givenGetPath_thenReturnJsonArray()
            throws Exception {

        Product product = new Product(null, "Mac", 2000.0, 20, "this is Mac", new Category(1, "laptop", "this is laptop"));

        List<Product> allProducts = Arrays.asList(product);
        given(service.findAll()).willReturn(allProducts);

        mvc.perform(get("/product")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].name", is(product.getName())));
    }

}