package com.nisum.test;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class NisumTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(NisumTestApplication.class, args);
    }

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                   .info(
        new Info()
                   .title("NISUM Test Project API")
                   .version("1.0")
                   .description("NISUM Test Project API Description")
                   .termsOfService("http://swagger.io/terms/")
                   .license(new io.swagger.v3.oas.models.info.License().name("Apache 2.0").url("http://springdoc.org")));

    }

}
