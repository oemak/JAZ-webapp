package com.webapp.webappdata.dto.request;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class ReviewDetailsCreateDTO {
    @Min(1) @Max(5)
    private Integer tasteRating;

    @Min(1) @Max(5)
    private Integer aromaRating;

    @Min(1) @Max(5)
    private Integer appearanceRating;

    private String purchaseLocation;
}