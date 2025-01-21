package com.webapp.webappdata.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ReviewCreateRequest {
    @NotBlank
    private String beerSku;

    @NotBlank
    private String reviewerNickname;

    @Min(1)
    @Max(5)
    private Integer rating;

    private String comment;

    private ReviewDetailsRequest details;
}