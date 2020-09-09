package com.cyr3con.shopapi.shopapi.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Product extends CatalogComponent implements Serializable {
    private Integer id;

    private String name;

    private Double price;

    @JsonProperty(value = "number_of_products_left")
    private Integer stock;

    @JsonInclude(value = JsonInclude.Include.NON_EMPTY)
    @JsonIgnore
    private String description;

    @JsonIgnore
    private Category category;

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public void print() {
        System.out.println("Product name: " + name + " Price: " + price);

    }
}
