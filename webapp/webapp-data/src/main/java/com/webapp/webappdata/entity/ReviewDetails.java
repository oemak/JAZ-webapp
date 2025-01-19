package com.webapp.webappdata.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "review_details")
@Data
public class ReviewDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer tasteRating;
    private Integer aromaRating;
    private Integer appearanceRating;
    private String purchaseLocation;
    private LocalDateTime purchaseDate;

    @OneToOne
    @JoinColumn(name = "review_id")
    private Review review;
}
