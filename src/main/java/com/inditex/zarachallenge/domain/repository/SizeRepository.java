package com.inditex.zarachallenge.domain.repository;

import com.inditex.zarachallenge.domain.model.SizeEntity;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Optional;

public interface SizeRepository extends JpaRepository<SizeEntity, Long> {

    default void updateAvailabilityAndLastUpdatedById(Long sizeId, boolean availability, LocalDateTime lastUpdated) {
        Optional<SizeEntity> optionalSizeEntity = findById(sizeId);
        if (optionalSizeEntity.isPresent()) {
            SizeEntity sizeEntity = optionalSizeEntity.get();
            sizeEntity.setAvailability(availability);
            sizeEntity.setLastUpdated(lastUpdated);
            save(sizeEntity);
        } else {
            throw new EntityNotFoundException("No se encontró la entidad con el ID: " + sizeId);
        }
    }
}
