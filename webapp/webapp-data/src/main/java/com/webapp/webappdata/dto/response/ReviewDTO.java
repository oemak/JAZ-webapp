package com.webapp.webappdata.dto.response;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class ReviewDTO {
    private Long id;
    private String reviewerNickname;
    private String comment;
    private Integer rating;
    private ReviewDetailsDTO details;
    private LocalDateTime createdAt;
}