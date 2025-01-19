package com.webapp.webappdata.service;

import com.webapp.webappdata.entity.Beer;
import com.webapp.webappdata.repository.BeerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BeerService {
    private final BeerRepository beerRepository;

    public Beer saveBeer(Beer beer) {
        return beerRepository.save(beer);
    }

    public Optional<Beer> getBeerBySku(String sku) {
        return beerRepository.findBySku(sku);
    }

    public List<Beer> getAllBeers() {
        return beerRepository.findAll();
    }

    public List<Beer> getBeersByBrewery(Long breweryId) {
        return beerRepository.findByBreweryId(breweryId);
    }
}