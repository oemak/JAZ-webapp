package com.webapp.webappdata.dto.response;

import lombok.Data;

@Data
public class BeerListItemDTO {
    private String sku;
    private String name;
    private String brewery;
    private String category;
    private String abv;
    private Double averageRating;
}