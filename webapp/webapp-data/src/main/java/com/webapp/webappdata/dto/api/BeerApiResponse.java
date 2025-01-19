package com.webapp.webappdata.dto.api;

import lombok.Data;

@Data
public class BeerApiResponse {
    private int code;
    private boolean error;
    private BeerDTO data;
}