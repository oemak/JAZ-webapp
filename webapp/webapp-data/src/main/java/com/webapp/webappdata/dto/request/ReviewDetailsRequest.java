package com.webapp.webappdata.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
public class ReviewDetailsRequest {
    @Min(1)
    @Max(5)
    private Integer appearanceRating;

    @Min(1)
    @Max(5)
    private Integer aromaRating;

    @Min(1)
    @Max(5)
    private Integer tasteRating;

    private String purchaseLocation;
}