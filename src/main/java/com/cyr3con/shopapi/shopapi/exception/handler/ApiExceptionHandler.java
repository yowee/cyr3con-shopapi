package com.cyr3con.shopapi.shopapi.exception.handler;

import com.cyr3con.shopapi.shopapi.domain.dto.ErrorMessage;
import com.cyr3con.shopapi.shopapi.exception.NoItem;
import com.cyr3con.shopapi.shopapi.exception.NotEnoghtItemsInStock;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;

import org.springframework.http.ResponseEntity;


@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = {NumberFormatException.class, NoItem.class, NotEnoghtItemsInStock.class, IOException.class, Exception.class})
    public ResponseEntity<ErrorMessage> handleBadInputRequestException(Exception ex) {
        String message = ex.getClass().getSimpleName() + " : " + ex.getMessage();
        ErrorMessage response = new ErrorMessage(message, "Make sure your input value is correct");

        return ResponseEntity.badRequest().body(response);
    }

}