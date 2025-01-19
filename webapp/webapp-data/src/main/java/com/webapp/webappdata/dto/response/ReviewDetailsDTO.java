package com.webapp.webappdata.dto.response;

import lombok.Data;

@Data
public class ReviewDetailsDTO {
    private Integer tasteRating;
    private Integer aromaRating;
    private Integer appearanceRating;
    private String purchaseLocation;
}