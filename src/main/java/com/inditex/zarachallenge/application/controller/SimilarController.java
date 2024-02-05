package com.inditex.zarachallenge.application.controller;


import com.inditex.zarachallenge.application.dto.response.ProductDetailResponse;
import com.inditex.zarachallenge.application.mapper.ProductMapper;
import com.inditex.zarachallenge.application.service.ProductService;
import com.inditex.zarachallenge.domain.model.ProductEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/product")
public class SimilarController {


    @Autowired
    private ProductService productService;

    @Autowired
    private ProductMapper productMapper;

    @GetMapping("/{productId}/similar")
    public ResponseEntity<ProductDetailResponse> getSimilarProducts(@PathVariable("productId") Integer productId) {
        // Aquí llamarías a tu servicio para obtener productos similares basados en el productId
        log.info("pase por aqui");


        try {
            ProductDetailResponse productDetailResponse;

            List<ProductEntity> similarProducts = productService.findSimilarProducts(productId);

            for (ProductEntity listProd: similarProducts) {
                log.info("listProd.get" + listProd.getId());
                log.info("listProd.getname" + listProd.getName());


            };

            log.info("entre a mapear");

            if (similarProducts.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            log.info("entre a mapear2");
            productDetailResponse = productMapper.mapProductEntitiesToProductDetailResponse(similarProducts);
            return new ResponseEntity<>(productDetailResponse, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }



        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
