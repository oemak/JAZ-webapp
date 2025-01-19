package com.webapp.webappdata.service;

import com.webapp.webappdata.client.BeerApiClient;
import com.webapp.webappdata.dto.api.BeerDTO;
import com.webapp.webappdata.entity.Beer;
import com.webapp.webappdata.mapper.BeerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BeerSynchronizationService {
    private final BeerApiClient beerApiClient;
    private final BeerService beerService;
    private final BeerMapper beerMapper;

    public void synchronizeBeer(String beerName) {
        BeerDTO beerDTO = beerApiClient.getBeerByName(beerName);
        Beer beer = beerMapper.toEntity(beerDTO);
        beerService.saveBeer(beer);
    }
}