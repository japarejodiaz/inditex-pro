package com.inditex.zarachallenge.domain.specification;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductProjection {

        private Integer id;
        private String name;
        private LocalDateTime validFrom;



    }
