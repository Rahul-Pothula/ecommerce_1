package com.rahul.productservice.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfiguration {

    // @Bean annotation is used to call up the method as soon as the spring application starts where you can find the object which is to be stored
    // in the application context
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}