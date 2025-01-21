package com.webapp.webappdata.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "reviews")
@Data
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String reviewerNickname;
    private String comment;
    private Integer rating;

    @CreationTimestamp
    private LocalDateTime createdAt;

    // Review -> Beer
    @ManyToOne
    @JoinColumn(name = "beer_sku")
    private Beer beer;

    // Review -> ReviewDetails
    @OneToOne(mappedBy = "review", cascade = CascadeType.ALL)
    private ReviewDetails reviewDetails;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReviewerNickname() {
        return reviewerNickname;
    }

    public void setReviewerNickname(String reviewerNickname) {
        this.reviewerNickname = reviewerNickname;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Beer getBeer() {
        return beer;
    }

    public void setBeer(Beer beer) {
        this.beer = beer;
    }

    public ReviewDetails getReviewDetails() {
        return reviewDetails;
    }

    public void setDetails(ReviewDetails reviewDetails) {
        this.reviewDetails = reviewDetails;
    }

}
