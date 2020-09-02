package com.cyr3con.shopapi.shopapi.exception;

public class NotEnoghtItemsInStock extends RuntimeException {
    public NotEnoghtItemsInStock(String message) {
        super(message);
    }
}
