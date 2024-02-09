package com.inditex.zarachallenge.infrastructure.exceptions;

public class ProductSimilarNotFoundException extends RuntimeException {

    public ProductSimilarNotFoundException(String message) {
        super(message);
    }

}