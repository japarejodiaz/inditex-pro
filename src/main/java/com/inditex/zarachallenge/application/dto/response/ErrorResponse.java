package com.inditex.zarachallenge.application.dto.response;

import lombok.*;
import java.io.Serializable;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorResponse implements Serializable {

    private String message;
    private int statusCode;

}