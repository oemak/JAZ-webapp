package com.webapp.webappapi.controller;

import com.webapp.webappdata.dto.api.ApiResponse;
import com.webapp.webappdata.dto.response.BeerDetailsDTO;
import com.webapp.webappdata.dto.request.BeerSearchRequest;
import com.webapp.webappapi.facade.BeerFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/beers")
@RequiredArgsConstructor
public class BeerController {

    private final BeerFacade beerFacade;

    @GetMapping
    public ApiResponse<List<BeerDetailsDTO>> searchBeers(BeerSearchRequest searchRequest) {
        return ApiResponse.success(beerFacade.searchBeers(searchRequest));
    }

    @GetMapping("/{sku}")
    public ApiResponse<BeerDetailsDTO> getBeerDetails(@PathVariable String sku) {
        return ApiResponse.success(beerFacade.getBeerDetails(sku));
    }
}