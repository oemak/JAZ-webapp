package com.webapp.webappdata.dto.response;

import lombok.Data;
import java.util.List;

@Data
public class BeerDetailsDTO {
    private String sku;
    private String name;
    private String description;
    private String abv;
    private String ibu;
    private BreweryDTO brewery;
    private BeerCategoryDTO category;
    private List<ReviewDTO> reviews;
    private Double averageRating;
}