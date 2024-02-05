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
import java.util.stream.Collectors;

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

        List<ProductResponseDto> list =  productEntities.stream()
                .map(productEntity -> {
                    return new ProductResponseDto(
                            productEntity.getId(),
                            productEntity.getName(),
                            productEntity.getOfferEntities().get(0).getPrice(),
                            productEntity.getSizeEntities().get(0).isAvailability()
                    );
                })
                .collect(Collectors.toList());

        return new ProductDetailResponse(list);
    }

}
