package com.inditex.zarachallenge.unit.entity;

import com.inditex.zarachallenge.domain.model.OfferEntity;
import com.inditex.zarachallenge.domain.model.ProductEntity;
import com.inditex.zarachallenge.domain.model.SizeEntity;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

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
