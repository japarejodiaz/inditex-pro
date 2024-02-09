package com.inditex.zarachallenge.unit.dto;

import com.inditex.zarachallenge.application.dto.response.ErrorResponse;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class ErrorResponseTest {

    @Test
    public void testErrorResponseEquality() {
        ErrorResponse errorResponse1 = new ErrorResponse("Test Message", 404);
        ErrorResponse errorResponse2 = new ErrorResponse("Test Message", 404);

        assertThat(errorResponse1).isEqualTo(errorResponse2);
    }

    @Test
    public void testErrorResponseAttributes() {
        ErrorResponse errorResponse = new ErrorResponse("Test Message", 404);

        assertThat(errorResponse.getMessage()).isEqualTo("Test Message");
        assertThat(errorResponse.getStatusCode()).isEqualTo(404);
    }


}
