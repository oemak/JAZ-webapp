package com.webapp.webappdata.dto.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class BeerDTO {
    private String sku;
    private String name;
    private String brewery;
    private String rating;
    private String category;

    @JsonProperty("sub_category_1")
    private String subCategory1;

    @JsonProperty("sub_category_2")
    private String subCategory2;

    @JsonProperty("sub_category_3")
    private String subCategory3;

    private String description;
    private String region;
    private String country;
    private String abv;
    private String ibu;

    @JsonProperty("tasting_notes")
    private String tastingNotes;

    @JsonProperty("food_pairing")
    private String foodPairing;

    @JsonProperty("suggested_glassware")
    private String suggestedGlassware;

    @JsonProperty("serving_temp_f")
    private String servingTempF;

    @JsonProperty("serving_temp_c")
    private String servingTempC;

    @JsonProperty("beer_type")
    private String beerType;

    private String features;
}