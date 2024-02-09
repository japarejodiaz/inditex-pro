package com.inditex.zarachallenge.infrastructure.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum ErrorEnum {

    NOT_PRODUCT_NOTFOUND("error.product.not.found"),
    NOT_PRODUCTS_SIMILAR_NOTFOUND("error.product.similar.not.found"),
    NOT_FOUND_PRICE("error.not.found.price"),
    PARAMETER_TYPE_MISMATCH("error.parameter.type.mismatch"),
    MISSING_PARAMETER("error.missing.parameter"),
    GENERIC_ERROR("error.generic");

    private String message;

}
