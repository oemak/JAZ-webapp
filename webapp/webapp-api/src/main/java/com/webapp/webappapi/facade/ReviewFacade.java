package com.webapp.webappapi.facade;

import com.webapp.webappdata.dto.request.ReviewCreateRequest;
import com.webapp.webappdata.dto.response.ReviewDTO;
import com.webapp.webappdata.service.BeerService;
import com.webapp.webappdata.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewFacade {
    private final ReviewService reviewService;
    private final BeerService beerService;

    public ReviewDTO createReview(ReviewCreateRequest request) {
        return reviewService.createReview(request);
    }

    public List<ReviewDTO> getBeerReviews(String sku) {
        if (!beerService.existsBySku(sku)) {
            throw new RuntimeException("Beer not found with SKU: " + sku);
        }
        return reviewService.getBeerReviews(sku);
    }

    public List<ReviewDTO> getRecentReviews(String sku, int limit) {
        if (!beerService.existsBySku(sku)) {
            throw new RuntimeException("Beer not found with SKU: " + sku);
        }
        return reviewService.getRecentReviews(sku, limit);
    }

    public Double getBeerAverageRating(String sku) {
        if (!beerService.existsBySku(sku)) {
            throw new RuntimeException("Beer not found with SKU: " + sku);
        }
        return reviewService.calculateAverageRating(sku);
    }

    public void deleteReview(Long id) {
        reviewService.deleteReview(id);
    }
}