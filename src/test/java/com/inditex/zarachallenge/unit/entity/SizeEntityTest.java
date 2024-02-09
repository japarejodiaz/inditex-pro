package com.inditex.zarachallenge.unit.entity;

import com.inditex.zarachallenge.domain.model.ProductEntity;
import com.inditex.zarachallenge.domain.model.SizeEntity;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.assertj.core.api.Assertions.*;

public class SizeEntityTest {

    @Test
    public void testSizeEntityInstanceTest() {

        LocalDateTime lastUpdated = LocalDateTime.now();
        ProductEntity productEntity = new ProductEntity();
        SizeEntity sizeEntity = SizeEntity.builder()
                .sizeId(1L)
                .size("Large")
                .availability(true)
                .lastUpdated(lastUpdated)
                .productEntity(productEntity)
                .build();

        assertThat(sizeEntity.getSizeId()).isEqualTo(1L);
        assertThat(sizeEntity.getSize()).isEqualTo("Large");
        assertThat(sizeEntity.isAvailability()).isTrue();
        assertThat(sizeEntity.getLastUpdated()).isEqualTo(lastUpdated);
        assertThat(sizeEntity.getProductEntity()).isEqualTo(productEntity);
    }
}

