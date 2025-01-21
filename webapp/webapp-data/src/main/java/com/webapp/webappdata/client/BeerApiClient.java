package com.webapp.webappdata.client;

import com.webapp.webappdata.dto.api.ApiResponse;
import com.webapp.webappdata.dto.api.BeerDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Slf4j
@Component
@RequiredArgsConstructor
public class BeerApiClient {
    private final RestTemplate restTemplate;
    private final String apiUrl = "https://beer9.p.rapidapi.com";

    public BeerDTO getBeerByName(String name) {
        String url = UriComponentsBuilder.fromUriString(apiUrl)
                .queryParam("name", name)
                .build()
                .toUriString();

        ApiResponse<BeerDTO> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<ApiResponse<BeerDTO>>() {}
        ).getBody();

        log.info("Raw API response: {}", response);

        if (response != null && response.getCode() == 200 && !response.isError()) {
            log.info("Successfully retrieved beer data: {}", response.getData());
            return response.getData();
        } else {
            log.error("Failed to retrieve beer data. Response: {}", response);
            return null;
        }
    }
}