package com.inditex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.inditex.zarachallenge.domain.repository"})
public class ZaraChallengeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZaraChallengeApplication.class, args);
	}

}