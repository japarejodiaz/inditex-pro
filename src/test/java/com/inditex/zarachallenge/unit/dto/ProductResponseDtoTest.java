package com.inditex.zarachallenge.unit.dto;

import com.inditex.zarachallenge.application.dto.response.ProductResponseDto;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductResponseDtoTest {

    @Test
    public void testProductResponseDtoEquality() {
        ProductResponseDto product1 = ProductResponseDto.builder()
                .id(1L)
                .name("Product 1")
                .price(BigDecimal.valueOf(10.99))
                .availability(true)
                .build();

        ProductResponseDto product2 = ProductResponseDto.builder()
                .id(1L)
                .name("Product 1")
                .price(BigDecimal.valueOf(10.99))
                .availability(true)
                .build();

        assertThat(product1).isEqualTo(product2);
    }

    @Test
    public void testProductResponseDtoAttributes() {
        ProductResponseDto product = ProductResponseDto.builder()
                .id(1L)
                .name("Product 1")
                .price(BigDecimal.valueOf(10.99))
                .availability(true)
                .build();

        assertThat(product.getId()).isEqualTo(1L);
        assertThat(product.getName()).isEqualTo("Product 1");
        assertThat(product.getPrice()).isEqualTo(BigDecimal.valueOf(10.99));
        assertThat(product.isAvailability()).isTrue();
    }

}
