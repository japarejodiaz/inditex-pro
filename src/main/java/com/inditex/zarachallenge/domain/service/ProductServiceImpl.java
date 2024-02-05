package com.inditex.zarachallenge.domain.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.inditex.zarachallenge.application.service.ProductService;
import com.inditex.zarachallenge.domain.model.ProductEntity;
import com.inditex.zarachallenge.domain.repository.ProductRepository;
import com.inditex.zarachallenge.domain.specification.ProductSpecification;
import com.inditex.zarachallenge.infrastructure.external.service.ProductExtService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductExtService productExtService;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public List<ProductEntity> findSimilarProducts(Integer productId) throws Exception {
        String ids = getSimilarIds(productId);
        List<Integer> listprod = objectMapper.readValue(ids, List.class);
        Specification<ProductEntity> spec = ProductSpecification.validOffersProjection(listprod);
        try {
            return productRepository.findAll(spec);
        } catch (Exception e) {
            throw new Exception(e.getMessage().toString());
        }
    }
    private List<ProductEntity> getProducts(List<ProductEntity> productList) {
        return productList.stream()
                .map(productEntity -> {
                    return new ProductEntity(
                            productEntity.getId(),
                            productEntity.getName(),
                            productEntity.getOfferEntities().stream().limit(1).collect(Collectors.toList()),
                            productEntity.getSizeEntities()
                    );
                })
                .collect(Collectors.toList());
    }

    public String getSimilarIds(Integer productId) {
        return productExtService.getSimilarIds(productId).defaultIfEmpty("")
                .block();
    }

}
