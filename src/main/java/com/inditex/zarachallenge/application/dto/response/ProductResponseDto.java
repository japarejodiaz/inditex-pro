package com.inditex.zarachallenge.application.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductResponseDto implements Serializable {
    private int id;
    private String name;
    private BigDecimal price;
    private boolean availability;
}
