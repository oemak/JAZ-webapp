package com.webapp.webappdata.dto.request;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class CreateReviewDTO {
    @NotBlank(message = "Nickname is required")
    private String reviewerNickname;

    @NotNull(message = "Comment is required")
    @Size(min = 10, max = 1000, message = "Comment must be between 10 and 1000 characters")
    private String comment;

    @NotNull(message = "Rating is required")
    @Min(1) @Max(5)
    private Integer rating;

    @NotNull(message = "Beer SKU is required")
    private String beerSku;

    private ReviewDetailsCreateDTO details;
}