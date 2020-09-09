package com.cyr3con.shopapi.shopapi.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;


import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Category implements Serializable {
    @JsonInclude(value = JsonInclude.Include.NON_EMPTY)
    private Integer id;

    @NotEmpty
    private String categoryName;

    @JsonInclude(value = JsonInclude.Include.NON_EMPTY)
    private String description;

}
