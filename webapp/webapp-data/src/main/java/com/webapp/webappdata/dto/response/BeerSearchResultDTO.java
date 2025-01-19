package com.webapp.webappdata.dto.response;

import lombok.Data;
import java.util.List;

@Data
public class BeerSearchResultDTO {
    private List<BeerListItemDTO> beers;
    private int totalPages;
    private long totalElements;
    private int currentPage;
}