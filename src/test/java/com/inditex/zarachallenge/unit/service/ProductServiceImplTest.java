package com.inditex.zarachallenge.unit.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.inditex.zarachallenge.domain.model.ProductEntity;
import com.inditex.zarachallenge.domain.repository.ProductRepository;
import com.inditex.zarachallenge.infrastructure.external.service.ProductExtService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

public class ProductServiceImplTest {

    @Mock
    private ProductRepository productRepository;

    @Mock
    private ProductExtService productExtService;

    @Mock
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindSimilarProducts_ProductFound_ReturnsSimilarProducts() throws Exception {

        Long productId = 1L;
        List<ProductEntity> productList = new ArrayList<>();
        ProductEntity productEntity = new ProductEntity();
        productList.add(productEntity);

        when(productRepository.findById(productId.longValue())).thenReturn(Optional.of(productEntity));
        when(objectMapper.readValue(anyString(), (Class<Object>) any())).thenReturn(new ArrayList<>());
        when(productExtService.getSimilarIds(productId)).thenReturn(Mono.just("[2, 3, 4]"));

    }


}
