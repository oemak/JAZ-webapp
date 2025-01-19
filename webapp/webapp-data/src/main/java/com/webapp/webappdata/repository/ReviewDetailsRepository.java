package com.webapp.webappdata.repository;

import com.webapp.webappdata.entity.ReviewDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReviewDetailsRepository extends JpaRepository<ReviewDetails, Long> {
    Optional<ReviewDetails> findByReviewId(Long reviewId);
}