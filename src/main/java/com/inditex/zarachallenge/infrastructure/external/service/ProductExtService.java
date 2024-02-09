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

    @Value("${base.url.url}")
    private String urlBase;

    @Value("${base.url.path}")
    private String urlPath;

    private WebClient webClient;

    public ProductExtService(WebClient.Builder webClientBuilder) {

        this.webClient = webClientBuilder.build();
    }

    public Mono<String> getSimilarIds(Integer productId) {

        this.webClient = WebClient.builder().baseUrl(urlBase).build();

        String url = UriComponentsBuilder.fromPath(urlPath)
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

