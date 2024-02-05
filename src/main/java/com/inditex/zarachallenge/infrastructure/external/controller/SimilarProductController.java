package com.inditex.zarachallenge.infrastructure.external.controller;

import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class SimilarProductController {

    @Hidden
    @GetMapping("/{productId}/similarids")
    public ResponseEntity<String> getSimilarIds(@PathVariable Long productId) {
        return ResponseEntity.ok("Lista de ids similares para el producto " + productId);
    }
}
