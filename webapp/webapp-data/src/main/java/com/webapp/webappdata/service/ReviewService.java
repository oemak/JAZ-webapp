package com.webapp.webappdata.service;

import com.webapp.webappdata.entity.Review;
import com.webapp.webappdata.repository.ReviewDetailsRepository;
import com.webapp.webappdata.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final ReviewDetailsRepository reviewDetailsRepository;

    public Review createReview(Review review) {
        return reviewRepository.save(review);
    }

    public List<Review> getReviewsByBeer(String beerSku) {
        return reviewRepository.findByBeerSku(beerSku);
    }

    public Optional<Review> getReviewById(Long id) {
        return reviewRepository.findById(id);
    }
}