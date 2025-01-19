package com.webapp.webappdata.dto.request;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class UpdateReviewDTO {
    @Size(min = 10, max = 1000)
    private String comment;

    @Min(1) @Max(5)
    private Integer rating;

    private ReviewDetailsCreateDTO details;
}