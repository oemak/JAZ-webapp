package com.webapp.webappdata.service;

import com.webapp.webappdata.dto.request.ReviewCreateRequest;
import com.webapp.webappdata.dto.request.ReviewDetailsRequest;
import com.webapp.webappdata.dto.response.ReviewDTO;
import com.webapp.webappdata.entity.Beer;
import com.webapp.webappdata.entity.Review;
import com.webapp.webappdata.entity.ReviewDetails;
import com.webapp.webappdata.mapper.ReviewMapper;
import com.webapp.webappdata.repository.BeerRepository;
import com.webapp.webappdata.repository.ReviewDetailsRepository;
import com.webapp.webappdata.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final ReviewDetailsRepository reviewDetailsRepository;
    private final BeerRepository beerRepository;
    private final ReviewMapper reviewMapper;

    @Transactional
    public ReviewDTO createReview(ReviewCreateRequest request) {
        Beer beer = beerRepository.findBySku(request.getBeerSku())
                .orElseThrow(() -> new RuntimeException("Beer not found: " + request.getBeerSku()));

        Review review = new Review();
        review.setBeer(beer);
        review.setReviewerNickname(request.getReviewerNickname());
        review.setRating(request.getRating());
        review.setComment(request.getComment());
        review.setCreatedAt(LocalDateTime.now());

        if (request.getDetails() != null) {
            ReviewDetails details = createReviewDetails(request.getDetails(), review);
            review.setReviewDetails(details);
        }

        Review savedReview = reviewRepository.save(review);
        return reviewMapper.toDto(savedReview);
    }

    public List<ReviewDTO> getBeerReviews(String beerSku) {
        List<Review> reviews = reviewRepository.findByBeerSku(beerSku);
        return reviews.stream()
                .map(reviewMapper::toDto)
                .toList();
    }

    public List<ReviewDTO> getRecentReviews(String beerSku, int limit) {
        List<Review> reviews = reviewRepository.findByBeerSkuOrderByCreatedAtDesc(beerSku);
        return reviews.stream()
                .limit(limit)
                .map(reviewMapper::toDto)
                .toList();
    }

    public Double calculateAverageRating(String beerSku) {
        return reviewRepository.findByBeerSku(beerSku).stream()
                .mapToInt(Review::getRating)
                .average()
                .orElse(0.0);
    }

    @Transactional
    public void deleteReview(Long id) {
        reviewRepository.deleteById(id);
    }

    private ReviewDetails createReviewDetails(ReviewDetailsRequest request, Review review) {
        ReviewDetails details = new ReviewDetails();
        details.setReview(review);
        details.setAppearanceRating(request.getAppearanceRating());
        details.setAromaRating(request.getAromaRating());
        details.setTasteRating(request.getTasteRating());
        details.setPurchaseLocation(request.getPurchaseLocation());
        return details;
    }
}