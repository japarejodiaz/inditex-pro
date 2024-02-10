package com.inditex.zarachallenge.infrastructure.external.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class ProductExtService {

    private WebClient webClient;

    @Value("${base.url}")
    private String baseUrl;

    @Value("${base.path}")
    private String basePath;

    public Mono<String> getSimilarIds(Long productId) {

        this.webClient = WebClient.builder().baseUrl(baseUrl).build();

        String url = UriComponentsBuilder.fromPath(basePath)
                .buildAndExpand(productId)
                .toUriString();

        return webClient.get()
                .uri(url)
                .retrieve()
                .bodyToMono(String.class)
                .onErrorResume(error -> {
                    log.error("Error occurred while fetching similar IDs: {}", error.getMessage());
                    return Mono.just("Error occurred while fetching similar IDs");
                });
    }



}

