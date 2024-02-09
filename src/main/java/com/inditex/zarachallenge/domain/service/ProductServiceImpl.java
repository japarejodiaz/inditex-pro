package com.inditex.zarachallenge.domain.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.inditex.zarachallenge.application.service.ProductService;
import com.inditex.zarachallenge.domain.model.ProductEntity;
import com.inditex.zarachallenge.domain.repository.ProductRepository;
import com.inditex.zarachallenge.domain.specification.ProductSpecification;
import com.inditex.zarachallenge.infrastructure.external.service.ProductExtService;
import com.inditex.zarachallenge.infrastructure.util.UtilMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
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

    @Autowired
    private UtilMessage utilMessage;

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");

    @Override
    public List<ProductEntity> findSimilarProducts(Integer productId) throws Exception {

        Optional<ProductEntity> productEntity = productRepository.findById(productId.longValue());

        if (!productEntity.isPresent()) {
            utilMessage.getProductNotFoundException(productId.toString(), LocalDateTime.now().format(formatter));
        }
        /**
         * Llama al servicio de productos similar ya validado el Producto
         */

        String ids = getSimilarIds(productId);
        List<Integer> listprod = objectMapper.readValue(ids, List.class);
        /**
         * Busca los similares si los hubiere
         */
        Specification<ProductEntity> spec = ProductSpecification.validOffersProjection(listprod);

        List<ProductEntity> listProduct = productRepository.findAll(spec);

        if (listProduct.isEmpty()) {
            utilMessage.getProductsSimilarNotFoundException(productId.toString(), LocalDateTime.now().format(formatter));
        }
        return listProduct;

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

    public String getSimilarIds(Integer productId) throws Exception {

        String similarIdsRecord = productExtService.getSimilarIds(productId).block();
        return similarIdsRecord;

    }

}
