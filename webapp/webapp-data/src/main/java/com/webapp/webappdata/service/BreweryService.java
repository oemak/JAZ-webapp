package com.webapp.webappdata.service;

import com.webapp.webappdata.entity.Brewery;
import com.webapp.webappdata.repository.BreweryAddressRepository;
import com.webapp.webappdata.repository.BreweryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BreweryService {
    private final BreweryRepository breweryRepository;
    private final BreweryAddressRepository breweryAddressRepository;

    public Brewery saveBrewery(Brewery brewery) {
        return breweryRepository.save(brewery);
    }

    public Optional<Brewery> getBreweryById(Long id) {
        return breweryRepository.findById(id);
    }

    public Optional<Brewery> getBreweryByName(String name) {
        return breweryRepository.findByName(name);
    }
}