package com.webapp.webappdata.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Configuration
public class RestTemplateConfig {

    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();

        ClientHttpRequestInterceptor interceptor = (request, body, execution) -> {
            HttpHeaders headers = request.getHeaders();
            headers.set("X-RapidAPI-Key", "aa59404e5dmshad432c5d878f8f7p173f5ejsn4477d98caf13");
            headers.set("X-RapidAPI-Host", "beer9.p.rapidapi.com");
            return execution.execute(request, body);
        };

        restTemplate.setInterceptors(Collections.singletonList(interceptor));
        return restTemplate;
    }
}
