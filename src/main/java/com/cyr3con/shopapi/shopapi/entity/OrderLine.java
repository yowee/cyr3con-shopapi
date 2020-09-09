package com.cyr3con.shopapi.shopapi.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.beans.Transient;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class OrderLine implements Serializable {
    @JsonInclude(value = JsonInclude.Include.NON_EMPTY)
    private Long id;

    @NotNull
    private Integer productId;

    @Min(value=1, message="must be equal or greater than 1")
    private Integer quantity;

    @Transient
    public Double getTotalPrice() {
        return null;
    }

}
