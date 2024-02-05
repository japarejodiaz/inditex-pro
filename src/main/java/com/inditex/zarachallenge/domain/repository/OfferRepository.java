package com.inditex.zarachallenge.domain.repository;

import com.inditex.zarachallenge.domain.model.OfferEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferRepository extends JpaRepository<OfferEntity, Integer> {
}
