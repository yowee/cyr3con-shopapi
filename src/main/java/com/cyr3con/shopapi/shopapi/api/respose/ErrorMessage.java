package com.cyr3con.shopapi.shopapi.api.respose;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ErrorMessage {

    private String message;

    private String reccomendation;

    public ErrorMessage(String message, String reccomendation) {
        super();
        this.message = message;
        this.reccomendation = reccomendation;
    }
}