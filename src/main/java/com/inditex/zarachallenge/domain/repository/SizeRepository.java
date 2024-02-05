package com.inditex.zarachallenge.domain.repository;

import com.inditex.zarachallenge.domain.model.SizeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SizeRepository extends JpaRepository<SizeEntity, Integer> {
}
