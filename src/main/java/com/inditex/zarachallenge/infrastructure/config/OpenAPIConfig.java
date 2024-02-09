package com.inditex.zarachallenge.infrastructure.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenAPIConfig {

  private static final String DEVURL = "http://localhost:8080";


  @Bean
  public OpenAPI myOpenAPI() {
    Server devServer = new Server();
    devServer.setUrl(DEVURL);
    devServer.setDescription("Server URL in Development environment for Test for Inditex");

    Contact contact = new Contact();
    contact.setName("Jesus Alexis Parejo Diaz");
    contact.setEmail("japarejo.diaz@gmail.com");
    contact.setUrl("www.linkedin.com/in/jesus-parejo-34986920/");

    License mitLicense = new License().name("MIT License").url("https://choosealicense.com/licenses/mit/");

    Info info = new Info()
        .title("Price of Similar Products API for TEST for Inditex")
        .version("1.0.0")
        .contact(contact)
        .description("This API allows you to check the similar products at an indicated time.")
        .license(mitLicense);

    return new OpenAPI().info(info).servers(List.of(devServer));
  }
}
