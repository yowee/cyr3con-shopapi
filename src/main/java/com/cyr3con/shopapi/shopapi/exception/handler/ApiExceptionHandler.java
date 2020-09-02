package com.cyr3con.shopapi.shopapi.exception.handler;

import com.cyr3con.shopapi.shopapi.exception.ErrorMessage;
import com.cyr3con.shopapi.shopapi.exception.NoProduct;
import com.cyr3con.shopapi.shopapi.exception.NotEnoghtItemsInStock;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = {NumberFormatException.class , NoProduct.class, NotEnoghtItemsInStock.class,IOException.class,RuntimeException.class,Exception.class})
    public ResponseEntity<ErrorMessage> handleBadInputRequestException(Exception ex) {
        String message = ex.getClass().getSimpleName() + " : " + ex.getMessage();
        ErrorMessage response = new ErrorMessage(message, "Make sure your input value is correct");

        return ResponseEntity.badRequest().body(response);
    }

//    @ExceptionHandler(value = { IOException.class })
//    public ResponseEntity<ErrorMessage> handleIoException(Exception ex) {
//        String  message = "Server error, cause " + ex.getClass().getSimpleName() + " : " + ex.getMessage();
//        ErrorMessage response = new ErrorMessage(message, "Try again in a few minutes");
//
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
//    }

}