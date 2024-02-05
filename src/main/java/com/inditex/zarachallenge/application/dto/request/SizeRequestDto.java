package com.inditex.zarachallenge.application.dto.request;

import lombok.Builder;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Builder
public class SizeRequestDto {
    private int sizeId;
    private String size;
    private boolean availability;
    private LocalDateTime lastUpdated;
    private int productId;
}
