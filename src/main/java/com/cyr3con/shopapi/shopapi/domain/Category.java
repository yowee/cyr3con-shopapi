package com.cyr3con.shopapi.shopapi.domain;

import lombok.*;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@AllArgsConstructor
public class Category implements Serializable {

    private Integer id;
    @NotEmpty
    private String categoryName;
    @NotEmpty
    private String description;

}
