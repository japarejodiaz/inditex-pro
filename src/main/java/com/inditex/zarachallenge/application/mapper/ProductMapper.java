package com.inditex.zarachallenge.application.mapper;

import com.inditex.zarachallenge.application.dto.response.ProductDetailResponse;
import com.inditex.zarachallenge.application.dto.response.ProductResponseDto;
import com.inditex.zarachallenge.domain.model.ProductEntity;

import java.util.List;

public interface ProductMapper {

    ProductDetailResponse mapProductEntitiesToProductDetailResponse(List<ProductEntity> productEntities);

}
