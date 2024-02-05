package com.inditex.zarachallenge.application.mapper;

import com.inditex.zarachallenge.application.dto.response.ProductDetailResponse;
import com.inditex.zarachallenge.domain.model.ProductEntity;
import com.inditex.zarachallenge.application.dto.request.ProductRequestDto;
import com.inditex.zarachallenge.application.dto.response.ProductResponseDto;

import java.util.List;

public interface ProductMapper {

    ProductResponseDto mapEntityToProductResponseDto(ProductEntity productEntity);

    ProductEntity mapRequestToProductEntity(ProductRequestDto productRequest);

    ProductDetailResponse mapProductEntitiesToProductDetailResponse(List<ProductEntity> productEntities);


}
