package com.webapp.webappdata.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
public class UpdateReviewRequest {
    @Min(1)
    @Max(5)
    private Integer rating;
    private String comment;
    private ReviewDetailsRequest details;
}