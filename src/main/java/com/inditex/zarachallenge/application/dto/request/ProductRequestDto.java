package com.inditex.zarachallenge.application.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductRequestDto {

    private Long id;
    private String name;
}
