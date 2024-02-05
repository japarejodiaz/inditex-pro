package com.inditex.zarachallenge.application.mapper.impl;

import com.inditex.zarachallenge.application.dto.response.ProductDetailResponse;
import com.inditex.zarachallenge.application.mapper.ProductMapper;
import com.inditex.zarachallenge.domain.model.ProductEntity;
import com.inditex.zarachallenge.application.dto.request.ProductRequestDto;
import com.inditex.zarachallenge.application.dto.response.ProductResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public ProductResponseDto mapEntityToProductResponseDto(ProductEntity productEntity) {
        return ProductResponseDto.builder()
                .id(productEntity.getId())
                .name(productEntity.getName())
                .build();
    }

    @Override
    public ProductEntity mapRequestToProductEntity(ProductRequestDto productRequest) {
        return ProductEntity.builder()
                .id(productRequest.getId())
                .name(productRequest.getName())
                .build();
    }

    @Override
    public ProductDetailResponse mapProductEntitiesToProductDetailResponse(List<ProductEntity> productEntities) {

        ProductDetailResponse result = new ProductDetailResponse();
        List<ProductResponseDto> productDetail = new ArrayList<>();
        log.info("entre a mapear");
        productEntities.forEach(product -> {

            ProductResponseDto productResponseDto = new ProductResponseDto();

            System.out.println("Product ID: " + product.getId());
            System.out.println("Product Name: " + product.getName());

            productResponseDto.setId(product.getId());
            productResponseDto.setName(product.getName());

            // Recorrer las ofertas asociadas al producto
            System.out.println("Offers:");
            product.getOfferEntities().forEach(offer -> {
                System.out.println("- Price: " + offer.getPrice());
                System.out.println("- Valid From: " + offer.getValidFrom());
                productResponseDto.setPrice(offer.getPrice());
            });

            // Recorrer los tamaños asociados al producto
            System.out.println("Sizes:");
            product.getSizeEntities().forEach(size -> {
                System.out.println("- Size: " + size.getSize());
                System.out.println("- Availability: " + size.isAvailability());
                System.out.println("- Last Updated: " + size.getLastUpdated());
                productResponseDto.setAvailability(size.isAvailability());
                // Puedes acceder a más atributos de Size si es necesario
            });
            productDetail.add(productResponseDto);
        });

        result.setProductDetail(productDetail);

        return result;
    }

}
