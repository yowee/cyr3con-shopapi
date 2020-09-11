package com.cyr3con.shopapi.shopapi.domain;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import java.util.Objects;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class OrderLine {

    @JsonInclude(value = JsonInclude.Include.NON_EMPTY)
    private Long id;

    @Valid
    @NotNull
    private Item item;

    @Min(value = 1, message = "must be equal or greater than 1")
    private Integer quantity;

    private double total;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderLine orderLine = (OrderLine) o;
        return Objects.equals(item.getId(), orderLine.item.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(item.getId());
    }

    public void updateTotalPrice() {
        this.total = this.item.getPrice()*this.quantity;
    }
}
