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
        // Crear una instancia de ProductEntity
        ProductEntity productEntity = ProductEntity.builder()
                .id(1L)
                .name("Product 1")
                .offerEntities(Collections.emptyList())
                .sizeEntities(Collections.emptyList())
                .build();


        assertThat(productEntity.getId()).isEqualTo(1L);
        assertThat(productEntity.getName()).isEqualTo("Product 1");
        assertThat(productEntity.getOfferEntities()).isEmpty(); // Lista vacia
        assertThat(productEntity.getSizeEntities()).isEmpty();  // Lista Vacia
    }

    @Test
    public void testProductEntityAttributes() {

        List<OfferEntity> offerEntities = new ArrayList<>();
        List<SizeEntity> sizeEntities = new ArrayList<>();

        ProductEntity productEntity = ProductEntity.builder()
                .id(1L)
                .name("Product 1")
                .offerEntities(offerEntities)
                .sizeEntities(sizeEntities)
                .build();

        assertThat(productEntity.getId()).isEqualTo(1L);
        assertThat(productEntity.getName()).isEqualTo("Product 1");
        assertThat(productEntity.getOfferEntities()).isEqualTo(offerEntities);
        assertThat(productEntity.getSizeEntities()).isEqualTo(sizeEntities);
    }


}
