package com.inditex.zarachallenge.domain.service;


import com.inditex.zarachallenge.application.service.ProductService;
import com.inditex.zarachallenge.domain.model.ProductEntity;
import com.inditex.zarachallenge.domain.repository.OfferRepository;
import com.inditex.zarachallenge.domain.repository.ProductDomainRepository;
import com.inditex.zarachallenge.domain.repository.SizeRepository;
import com.inditex.zarachallenge.application.mapper.ProductMapper;
import com.inditex.zarachallenge.domain.specification.ProductSpecification;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDomainRepository productDomainRepository;

    @Autowired
    private OfferRepository offerRepository;

    @Autowired
    private SizeRepository sizeRepository;

    @Autowired
    private ProductMapper productMapper;



    @Override
    public List<ProductEntity> findSimilarProducts(Integer productId) throws Exception {



        //*** llamar al servicio de lista de similares
        log.info("pase por 2");
        List<Integer> listprod = Arrays.asList(2, 3, 4);
        // validar que el producto exista
        // llamar y crear la especificacion
        log.info("pase por 3");
        Specification<ProductEntity> spec = ProductSpecification.validOffersProjection(listprod);
        log.info("pase por 4");
        try {
            List<ProductEntity> productDetailList = productDomainRepository.findAll(spec);



            for (ProductEntity listProd: productDetailList) {
                log.info("listProd.get" + listProd.getId());
                log.info("listProd.getname" + listProd.getName());
                log.info("listProd.otros Offer" + listProd.getOfferEntities().get(0).getId());
                log.info("listProd.otros Offer" + listProd.getOfferEntities().get(0).getValidFrom());
                log.info("listProd.otros Offer" + listProd.getSizeEntities().get(0).isAvailability());

            };


            List<ProductEntity> distinctObjects = productDetailList.stream()
                    .collect(Collectors.toMap(ProductEntity::getId, obj -> obj, (existing, replacement) -> existing))
                    .values()
                    .stream()
                    .collect(Collectors.toList());
/*
            distinctObjects.forEach(System.out::println);*/
            return distinctObjects;
        } catch (Exception e) {
            throw new Exception(e.getMessage().toString());
        }


    }



}
