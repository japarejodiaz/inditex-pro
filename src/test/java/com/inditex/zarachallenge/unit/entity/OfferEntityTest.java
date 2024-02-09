package com.inditex.zarachallenge.unit.entity;

import com.inditex.zarachallenge.domain.model.OfferEntity;
import com.inditex.zarachallenge.domain.model.ProductEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import static org.assertj.core.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class OfferEntityTest {

    @Mock
    private ProductEntity productEntity;

    @Test
    public void testOfferEntity() {

        OfferEntity offerEntity = OfferEntity.builder()
                .id(1L)
                .validFrom(LocalDateTime.now())
                .price(BigDecimal.valueOf(20.99))
                .productEntity(productEntity)
                .build();

        assertThat(offerEntity.getId()).isEqualTo(1L);
        assertThat(offerEntity.getValidFrom()).isNotNull(); // Verificar que la fecha no sea nula
        assertThat(offerEntity.getPrice()).isEqualTo(BigDecimal.valueOf(20.99));
        assertThat(offerEntity.getProductEntity()).isEqualTo(productEntity); // Verificar que el producto sea el mismo objeto simulado
    }
}
