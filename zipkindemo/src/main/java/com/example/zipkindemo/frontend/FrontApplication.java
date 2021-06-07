package com.example.zipkindemo.frontend;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class FrontApplication {
    public static void main(String[] args) {
        SpringApplication.run(FrontApplication.class,
                "--spring.application.name=frontend",
                "--server.port=8080");
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplateBuilder().build();
    }

    @RestController
    @Slf4j
    static class FrontController {
        @Autowired
        RestTemplate restTemplate;

        @GetMapping("/order/request")
        public String request() {
            log.info("frontend");
            String response = restTemplate.getForObject("http://localhost:8081/order/100", String.class);
            return response;
        }
    }

}
