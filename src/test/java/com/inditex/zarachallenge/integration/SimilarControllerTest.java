package com.inditex.zarachallenge.integration;

import com.inditex.zarachallenge.application.controller.SimilarController;
import com.inditex.zarachallenge.application.dto.response.ProductDetailResponse;
import com.inditex.zarachallenge.application.service.ProductService;
import com.inditex.zarachallenge.domain.model.ProductEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class SimilarControllerTest {

    @Mock
    private ProductService productService;

    @InjectMocks
    private SimilarController similarController;

    @BeforeEach
    void setUp() {
        productService = mock(ProductService.class);
        similarController = new SimilarController();

    }

    @Test
    void getSimilarProducts_ProductsFound_Returns200() throws Exception {

        Long productId = 1L;
        List<ProductEntity> productList = new ArrayList<>();
        productList.add(new ProductEntity());
        when(productService.findSimilarProducts(productId)).thenReturn(productList);

        ResponseEntity<ProductDetailResponse> responseEntity = similarController.getSimilarProducts(productId);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        verify(productService, times(1)).findSimilarProducts(productId);
    }

    @Test
    void getSimilarProducts_ProductsNotFound_Returns404() throws Exception {

        Long productId = 1L;
        when(productService.findSimilarProducts(productId)).thenReturn(new ArrayList<>());

        ResponseEntity<ProductDetailResponse> responseEntity = similarController.getSimilarProducts(productId);

        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
        verify(productService, times(1)).findSimilarProducts(productId);
    }
}
