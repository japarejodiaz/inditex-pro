package com.inditex.zarachallenge.unit.constant;

import com.inditex.zarachallenge.infrastructure.constant.ErrorEnum;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class ErrorEnumTest {

    @Test
    public void testEnumValues() {
        assertThat(ErrorEnum.NOT_PRODUCT_NOTFOUND.getMessage()).isEqualTo("error.product.not.found");
        assertThat(ErrorEnum.NOT_PRODUCTS_SIMILAR_NOTFOUND.getMessage()).isEqualTo("error.product.similar.not.found");
        assertThat(ErrorEnum.NOT_FOUND_PRICE.getMessage()).isEqualTo("error.not.found.price");
        assertThat(ErrorEnum.PARAMETER_TYPE_MISMATCH.getMessage()).isEqualTo("error.parameter.type.mismatch");
        assertThat(ErrorEnum.MISSING_PARAMETER.getMessage()).isEqualTo("error.missing.parameter");
        assertThat(ErrorEnum.GENERIC_ERROR.getMessage()).isEqualTo("error.generic");
    }

}
