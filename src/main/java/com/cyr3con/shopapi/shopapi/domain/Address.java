package com.cyr3con.shopapi.shopapi.domain;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Data
public class Address {
    @NotEmpty
    private String street;

    @NotEmpty
    private String city;

    @Size(min=2, max=2, message = "State must be 2 characters")
    private String state;

    @Size(min = 5, max = 5, message = "Zip code must be 5 characters")
    private String zipCode;

    public Address() {
    }


}
