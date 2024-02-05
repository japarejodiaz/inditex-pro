package com.inditex.zarachallenge.application.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OfferResponseDto implements Serializable {

    private int id;
    private LocalDateTime validFrom;
    private BigDecimal price;
    private ProductResponseDto product;
}
