package com.cyr3con.shopapi.shopapi.domain.dto;

import com.cyr3con.shopapi.shopapi.domain.OrderLine;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class OrderRequest implements Serializable {
    @Valid
    @NotEmpty
    Set<OrderLine> orderLineSet;

}
