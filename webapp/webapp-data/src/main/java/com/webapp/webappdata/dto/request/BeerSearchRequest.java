package com.webapp.webappdata.dto.request;

import lombok.Data;

@Data
public class BeerSearchRequest {
    private String name;
    private String brewery;
    private String category;
}