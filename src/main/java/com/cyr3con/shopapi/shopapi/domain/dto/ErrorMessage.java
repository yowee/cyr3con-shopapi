package com.cyr3con.shopapi.shopapi.domain.dto;

import lombok.*;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorMessage implements Serializable {
    private String message;
    private String recommendation;

}