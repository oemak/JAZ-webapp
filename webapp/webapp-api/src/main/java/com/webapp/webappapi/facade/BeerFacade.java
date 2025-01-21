package com.webapp.webappapi.facade;

import com.webapp.webappdata.dto.request.BeerSearchRequest;
import com.webapp.webappdata.dto.response.BeerDetailsDTO;
import com.webapp.webappdata.dto.response.ReviewDTO;
import com.webapp.webappdata.service.BeerService;
import com.webapp.webappdata.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BeerFacade {
    private final BeerService beerService;
    private final ReviewService reviewService;

    public List<BeerDetailsDTO> searchBeers(BeerSearchRequest request) {
        return beerService.searchBeers(request);
    }

    public BeerDetailsDTO getBeerDetails(String sku) {
        BeerDetailsDTO beerDetails = beerService.getBeerDetails(sku)
                .orElseThrow(() -> new RuntimeException("Beer not found with SKU: " + sku));

        Double avgRating = reviewService.calculateAverageRating(sku);
        List<ReviewDTO> reviews = reviewService.getBeerReviews(sku);

        return beerDetails;
    }
}