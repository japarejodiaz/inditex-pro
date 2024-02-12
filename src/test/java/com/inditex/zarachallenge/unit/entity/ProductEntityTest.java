package com.inditex.zarachallenge.unit.entity;

import com.inditex.zarachallenge.domain.model.ProductEntity;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductEntityTest {

    @Test
    public void testProductEntity() {

        ProductEntity productEntity = ProductEntity.builder()
                .id(1L)
                .name("Product 1")
                .offerEntities(Collections.emptyList())
                .sizeEntities(Collections.emptyList())
                .build();


        assertThat(productEntity.getId()).isEqualTo(1L);
        assertThat(productEntity.getName()).isEqualTo("Product 1");
        assertThat(productEntity.getOfferEntities()).isEmpty();
        assertThat(productEntity.getSizeEntities()).isEmpty();


    }
}
