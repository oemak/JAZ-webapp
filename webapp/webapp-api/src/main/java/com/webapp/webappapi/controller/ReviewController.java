package com.webapp.webappapi.controller;

import com.webapp.webappdata.dto.api.ApiResponse;
import com.webapp.webappdata.dto.response.ReviewDTO;
import com.webapp.webappdata.dto.request.ReviewCreateRequest;
import com.webapp.webappapi.facade.ReviewFacade;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class ReviewController {

    private final ReviewFacade reviewFacade;

    @PostMapping
    public ApiResponse<ReviewDTO> createReview(@Valid @RequestBody ReviewCreateRequest request) {
        return ApiResponse.success(reviewFacade.createReview(request));
    }

    @GetMapping("/beer/{sku}")
    public ApiResponse<List<ReviewDTO>> getBeerReviews(@PathVariable String sku) {
        return ApiResponse.success(reviewFacade.getBeerReviews(sku));
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> deleteReview(@PathVariable Long id) {
        reviewFacade.deleteReview(id);
        return ApiResponse.success(null);
    }
}