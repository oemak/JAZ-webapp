package com.webapp.webappdata.service;

import com.webapp.webappdata.client.BeerApiClient;
import com.webapp.webappdata.dto.request.BeerSearchRequest;
import com.webapp.webappdata.dto.response.BeerDetailsDTO;
import com.webapp.webappdata.entity.Beer;
import com.webapp.webappdata.mapper.BeerMapper;
import com.webapp.webappdata.repository.BeerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class BeerService {
    private final BeerRepository beerRepository;
    private final BeerApiClient beerApiClient;
    private final BeerMapper beerMapper;

    public Beer saveBeer(Beer beer) {
        return beerRepository.save(beer);
    }

    public Optional<BeerDetailsDTO> getBeerDetails(String sku) {
        Optional<Beer> localBeer = beerRepository.findBySku(sku);
        if (localBeer.isPresent()) {
            return Optional.of(beerMapper.toDetailsDto(localBeer.get()));
        }

        var beerDto = beerApiClient.getBeerByName(sku);
        if (beerDto != null) {
            Beer beer = beerMapper.toEntity(beerDto);
            Beer savedBeer = beerRepository.save(beer);
            return Optional.of(beerMapper.toDetailsDto(savedBeer));
        }

        return Optional.empty();
    }

    public List<BeerDetailsDTO> searchBeers(BeerSearchRequest request) {
        if (request.getName() != null) {
            var beerDto = beerApiClient.getBeerByName(request.getName());
            if (beerDto != null) {
                Beer beer = beerMapper.toEntity(beerDto);
                Beer savedBeer = beerRepository.save(beer);
                return List.of(beerMapper.toDetailsDto(savedBeer));
            }
        }

        return beerRepository.findAll().stream()
                .map(beerMapper::toDetailsDto)
                .collect(Collectors.toList());
    }

    public boolean existsBySku(String sku) {
        return beerRepository.findBySku(sku).isPresent();
    }
}