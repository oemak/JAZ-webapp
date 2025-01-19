package com.webapp.webappdata.repository;

import com.webapp.webappdata.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByBeerSku(String beerSku);
    List<Review> findByReviewerNickname(String reviewerNickname);
}