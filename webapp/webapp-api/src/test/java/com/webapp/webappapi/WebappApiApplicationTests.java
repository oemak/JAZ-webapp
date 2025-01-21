package com.webapp.webappapi;

import com.webapp.webappdata.dto.api.ApiResponse;
import com.webapp.webappdata.dto.request.BeerSearchRequest;
import com.webapp.webappdata.dto.response.BeerDetailsDTO;
import com.webapp.webappdata.dto.response.ReviewDTO;
import com.webapp.webappdata.dto.request.ReviewCreateRequest;
import com.webapp.webappdata.dto.request.ReviewDetailsRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class WebappApiApplicationTests {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void testBeerEndpoints() {
        // Test wyszukiwania piwa
        BeerSearchRequest searchRequest = new BeerSearchRequest();
        searchRequest.setName("Magnify The Ties");

        ResponseEntity<ApiResponse<List<BeerDetailsDTO>>> searchResponse = restTemplate.exchange(
                "http://localhost:" + port + "/api/beers?name={name}",
                org.springframework.http.HttpMethod.GET,
                null,
                new ParameterizedTypeReference<ApiResponse<List<BeerDetailsDTO>>>() {},
                searchRequest.getName()
        );

        System.out.println("Status code: " + searchResponse.getStatusCode());
        System.out.println("Response body: " + searchResponse.getBody());

        assertThat(searchResponse.getStatusCode().is2xxSuccessful()).isTrue();
        assertThat(searchResponse.getBody()).isNotNull();
        assertThat(searchResponse.getBody().getData()).isNotNull();

        // Test pobierania szczegółów piwa
        String sku = "118161"; // SKU z poprzedniego testu
        ResponseEntity<ApiResponse> detailsResponse = restTemplate.getForEntity(
                "http://localhost:" + port + "/api/beers/{sku}",
                ApiResponse.class,
                sku
        );

        assertThat(detailsResponse.getStatusCode().is2xxSuccessful()).isTrue();
        assertThat(detailsResponse.getBody()).isNotNull();
        assertThat(detailsResponse.getBody().getData()).isNotNull();

        // Test dodawania recenzji
        ReviewCreateRequest reviewRequest = new ReviewCreateRequest();
        reviewRequest.setBeerSku(sku);
        reviewRequest.setReviewerNickname("testUser");
        reviewRequest.setRating(5);
        reviewRequest.setComment("Great beer!");

        ReviewDetailsRequest detailsRequest = new ReviewDetailsRequest();
        detailsRequest.setAppearanceRating(5);
        detailsRequest.setAromaRating(4);
        detailsRequest.setTasteRating(5);
        detailsRequest.setPurchaseLocation("Test Store");
        reviewRequest.setDetails(detailsRequest);

        ResponseEntity<ApiResponse> reviewResponse = restTemplate.postForEntity(
                "http://localhost:" + port + "/api/reviews",
                reviewRequest,
                ApiResponse.class
        );

        assertThat(reviewResponse.getStatusCode().is2xxSuccessful()).isTrue();
        assertThat(reviewResponse.getBody()).isNotNull();
        assertThat(reviewResponse.getBody().getData()).isNotNull();
    }
}