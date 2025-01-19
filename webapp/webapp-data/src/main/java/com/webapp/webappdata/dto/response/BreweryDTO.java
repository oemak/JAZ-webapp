package com.webapp.webappdata.dto.response;

import lombok.Data;

@Data
public class BreweryDTO {
    private Long id;
    private String name;
    private String region;
    private String country;
    private BreweryAddressDTO address;
}