package com.inditex.zarachallenge.application.controller;

import com.inditex.zarachallenge.application.dto.response.ProductDetailResponse;
import com.inditex.zarachallenge.application.mapper.ProductMapper;
import com.inditex.zarachallenge.application.service.ProductService;
import com.inditex.zarachallenge.domain.model.ProductEntity;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shaded_package.io.swagger.annotations.ApiOperation;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/product")
public class SimilarController {


    @Autowired
    private ProductService productService;

    @Autowired
    private ProductMapper productMapper;



    @GetMapping(value = "/{productId}/similar",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(value = "Get a Similar Products for one identifier Product", httpMethod = "GET", notes = "Get a Similar Products a identifier Product",
            response = String.class)
    @Operation(summary = "Get a similars product for one identifier product", method = "GET")
    public ResponseEntity<ProductDetailResponse> getSimilarProducts(@PathVariable("productId") Long productId) throws Exception {

            ProductDetailResponse productDetailResponse;
            List<ProductEntity> similarProducts = productService.findSimilarProducts(productId);
            if (similarProducts.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            productDetailResponse = productMapper.mapProductEntitiesToProductDetailResponse(similarProducts);
            return new ResponseEntity<>(productDetailResponse, HttpStatus.OK);

    }
}
