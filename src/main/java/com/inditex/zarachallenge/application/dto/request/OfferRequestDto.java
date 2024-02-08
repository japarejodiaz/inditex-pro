package com.inditex.zarachallenge.application.dto.request;

import lombok.Builder;
import lombok.Data;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
public class OfferRequestDto implements Serializable {

    private Long id;
    private LocalDateTime validFrom;
    private BigDecimal price;
    private int productId;

}
