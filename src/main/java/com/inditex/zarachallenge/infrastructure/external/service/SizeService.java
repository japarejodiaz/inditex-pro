package com.inditex.zarachallenge.infrastructure.external.service;

import com.inditex.zarachallenge.domain.model.ProductAvailabilityEvent;
import com.inditex.zarachallenge.domain.repository.SizeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SizeService {

    @Autowired
    private SizeRepository sizeRepository;
    public void updateProductAvailability(ProductAvailabilityEvent event) {
        sizeRepository.updateAvailabilityAndLastUpdatedById(event.getSizeId(), event.isAvailability(), event.getUpdate().toLocalDateTime());
    }
}
