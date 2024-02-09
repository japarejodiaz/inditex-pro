package com.inditex.zarachallenge.infrastructure.external.controller;

import com.inditex.zarachallenge.infrastructure.external.service.ProductExternalSimilarService;
import com.inditex.zarachallenge.infrastructure.util.UtilMessage;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shaded_package.io.swagger.annotations.ApiOperation;

import java.time.LocalDateTime;

@Slf4j
@RestController
@RequestMapping("/product")
public class SimilarProductController {

    @Autowired
    private ProductExternalSimilarService productExternalSimilarService;

    @Autowired
    private UtilMessage utilMessage;

    //@Hidden
    @GetMapping(value = "/{productId}/similarids",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(value = "Get a Similar Products a identifier Product", httpMethod = "GET", notes = "Get a Similar Products a identifier Product",
            response = String.class)
    @Operation(summary = "Get a similars product for a identifier product", method = "GET")
    public ResponseEntity<String> getSimilarIds(@PathVariable Long productId) {

        String resultProductSimilars = productExternalSimilarService.findProductSimilar(productId.intValue());

        return ResponseEntity.ok(resultProductSimilars);
    }
}
