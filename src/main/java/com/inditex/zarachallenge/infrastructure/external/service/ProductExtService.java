package com.inditex.zarachallenge.infrastructure.external.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

@Service
public class ProductExtService {

    private final WebClient webClient;

    public ProductExtService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:3000").build();
        // Ajusta la URL base según la configuración de tu aplicación
    }

    public Mono<String> getSimilarIds(Integer productId) {
        String url = UriComponentsBuilder.fromPath("/product/{productId}/similarids")
                .buildAndExpand(productId)
                .toUriString();

        return webClient.get()
                .uri(url)
                .retrieve()
                .bodyToMono(String.class);
    }
}

