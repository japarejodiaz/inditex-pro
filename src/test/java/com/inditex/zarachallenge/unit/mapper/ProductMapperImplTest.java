package com.inditex.zarachallenge.unit.mapper;

import com.inditex.zarachallenge.application.dto.response.ProductDetailResponse;
import com.inditex.zarachallenge.application.dto.response.ProductResponseDto;
import com.inditex.zarachallenge.application.mapper.impl.ProductMapperImpl;
import com.inditex.zarachallenge.domain.model.OfferEntity;
import com.inditex.zarachallenge.domain.model.ProductEntity;
import com.inditex.zarachallenge.domain.model.SizeEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductMapperImplTest {

    private ProductMapperImpl productMapper;

    @BeforeEach
    void setUp() {
        productMapper = new ProductMapperImpl();
    }

    @Test
    void mapProductEntitiesToProductDetailResponse_ShouldMapCorrectly() {

        List<ProductEntity> productEntities = createProductEntities();
        ProductDetailResponse productDetailResponse = productMapper.mapProductEntitiesToProductDetailResponse(productEntities);
        assertEquals(productEntities.size(), productDetailResponse.getProductDetail().size());
        for (int i = 0; i < productEntities.size(); i++) {
            ProductEntity productEntity = productEntities.get(i);
            ProductResponseDto productResponseDto = productDetailResponse.getProductDetail().get(i);

            assertEquals(productEntity.getId(), productResponseDto.getId());
            assertEquals(productEntity.getName(), productResponseDto.getName());
            assertEquals(productEntity.getOfferEntities().get(0).getPrice(), productResponseDto.getPrice());
            assertEquals(productEntity.getSizeEntities().get(0).isAvailability(), productResponseDto.isAvailability());
        }
    }

    private List<ProductEntity> createProductEntities() {
        List<ProductEntity> productEntities = new ArrayList<>();
        ProductEntity productEntity1 = new ProductEntity();
        productEntity1.setId(1L);
        productEntity1.setName("Product 1");

        OfferEntity offerEntity1 = new OfferEntity();
        offerEntity1.setPrice(BigDecimal.valueOf(10.99));
        List<OfferEntity> offerEntities1 = new ArrayList<>();
        offerEntities1.add(offerEntity1);
        productEntity1.setOfferEntities(offerEntities1);

        SizeEntity sizeEntity1 = new SizeEntity();
        sizeEntity1.setAvailability(true);
        List<SizeEntity> sizeEntities1 = new ArrayList<>();
        sizeEntities1.add(sizeEntity1);
        productEntity1.setSizeEntities(sizeEntities1);

        ProductEntity productEntity2 = new ProductEntity();
        productEntity2.setId(2L);
        productEntity2.setName("Product 2");

        OfferEntity offerEntity2 = new OfferEntity();
        offerEntity2.setPrice(BigDecimal.valueOf(20.99));
        List<OfferEntity> offerEntities2 = new ArrayList<>();
        offerEntities2.add(offerEntity2);
        productEntity2.setOfferEntities(offerEntities2);

        SizeEntity sizeEntity2 = new SizeEntity();
        sizeEntity2.setAvailability(false);
        List<SizeEntity> sizeEntities2 = new ArrayList<>();
        sizeEntities2.add(sizeEntity2);
        productEntity2.setSizeEntities(sizeEntities2);

        productEntities.add(productEntity1);
        productEntities.add(productEntity2);

        return productEntities;
    }
}
