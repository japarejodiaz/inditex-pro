package com.inditex.zarachallenge.unit.dto;

import com.inditex.zarachallenge.application.dto.response.ProductDetailResponse;
import com.inditex.zarachallenge.application.dto.response.ProductResponseDto;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.Assertions.*;

public class ProductDetailResponseTest {

    @Test
    public void testProductDetailResponse() {

        ProductResponseDto productDto1 = ProductResponseDto.builder()
                .id(1L)
                .name("Product 1")
                .price(BigDecimal.valueOf(10.99))
                .availability(true)
                .build();

        ProductResponseDto productDto2 = ProductResponseDto.builder()
                .id(2L)
                .name("Product 2")
                .price(BigDecimal.valueOf(15.99))
                .availability(false)
                .build();

        List<ProductResponseDto> productList = Arrays.asList(productDto1, productDto2);
        ProductDetailResponse productDetailResponse = ProductDetailResponse.builder()
                .productDetail(productList)
                .build();

        assertThat(productDetailResponse.getProductDetail()).isNotNull();
        assertThat(productDetailResponse.getProductDetail()).hasSize(2);
        assertThat(productDetailResponse.getProductDetail()).containsExactly(productDto1, productDto2);
    }
}
