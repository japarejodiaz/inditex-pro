package com.inditex.zarachallenge.domain.specification;

import com.inditex.zarachallenge.domain.model.OfferEntity;
import com.inditex.zarachallenge.domain.model.ProductEntity;
import com.inditex.zarachallenge.domain.model.SizeEntity;
import jakarta.persistence.criteria.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ProductSpecification {

    private ProductSpecification() {}

    public static Specification<ProductEntity> validOffersProjection(List<Long> productIds) {

        List<Predicate> predicates = new ArrayList<>();

        return (root, query, criteriaBuilder) -> {

            Join<ProductEntity, SizeEntity> sizeJoin = root.join("sizeEntities", JoinType.INNER);
            Join<ProductEntity, OfferEntity> offerJoin = root.join("offerEntities", JoinType.INNER);
            predicates.add(criteriaBuilder.lessThanOrEqualTo(offerJoin.get("validFrom"), LocalDateTime.now()));
            predicates.add(criteriaBuilder.equal(root.get("id"), sizeJoin.get("productEntity").get("id")));
            predicates.add(criteriaBuilder.equal(root.get("id"), offerJoin.get("productEntity").get("id")));
            predicates.add(root.get("id").in(productIds));

            query.orderBy(criteriaBuilder.desc(root.get("id")), criteriaBuilder.desc(root.get("offerEntities").get("validFrom")));

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}