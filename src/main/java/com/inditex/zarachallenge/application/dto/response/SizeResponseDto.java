package com.inditex.zarachallenge.application.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SizeResponseDto implements Serializable {

    private int sizeId;
    private String size;
    private boolean availability;
    private LocalDateTime lastUpdated;
    private ProductResponseDto product;
}
