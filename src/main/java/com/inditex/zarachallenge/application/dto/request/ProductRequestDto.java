package com.inditex.zarachallenge.application.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductRequestDto {

    private int id;
    private String name;
}
