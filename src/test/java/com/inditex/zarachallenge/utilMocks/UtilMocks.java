package com.inditex.zarachallenge.utilMocks;

import com.inditex.zarachallenge.application.dto.response.ProductResponseDto;

import java.math.BigDecimal;

public class UtilMocks {


    public static ProductResponseDto createProduct(Long id, String name, BigDecimal price, boolean availability) {
        return ProductResponseDto.builder()
                .id(id)
                .name(name)
                .price(price)
                .availability(availability)
                .build();
    }

    public static ProductResponseDto createDefaultProduct() {
        return ProductResponseDto.builder()
                .id(1L)
                .name("Product 1")
                .price(BigDecimal.valueOf(10.99))
                .availability(true)
                .build();
    }

    public ProductResponseDto getProductUno() {

        return ProductResponseDto.builder()
                .id(1L)
                .name("Product 1")
                .price(BigDecimal.valueOf(10.99))
                .availability(true)
                .build();

    }

    public ProductResponseDto getProductDos() {
        return ProductResponseDto.builder()
                .id(2L)
                .name("Product 2")
                .price(BigDecimal.valueOf(15.99))
                .availability(false)
                .build();
    }

}
