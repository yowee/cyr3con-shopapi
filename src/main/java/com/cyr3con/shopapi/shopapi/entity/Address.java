package com.cyr3con.shopapi.shopapi.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Data
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Address {
    @JsonInclude(value = JsonInclude.Include.NON_EMPTY)
    @NotNull
    private String street;

    @JsonInclude(value = JsonInclude.Include.NON_EMPTY)
    @NotNull
    private String city;

    @JsonInclude(value = JsonInclude.Include.NON_EMPTY)
    @NotNull
    @Size(min = 2, max = 2, message = "State must be 2 characters")
    private String state;

    @JsonInclude(value = JsonInclude.Include.NON_EMPTY)
    @Size(min = 5, max = 5, message = "Zip code must be 5 characters")
    @NotNull
    private String zipCode;

}
