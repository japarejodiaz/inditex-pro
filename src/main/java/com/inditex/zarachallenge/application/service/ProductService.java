package com.inditex.zarachallenge.application.service;

import com.inditex.zarachallenge.domain.model.ProductEntity;

import java.util.List;

public interface ProductService {
    List<ProductEntity> findSimilarProducts(Integer productId) throws Exception;
}
