package com.webapp.webappdata.service;

import com.webapp.webappdata.entity.BeerCategory;
import com.webapp.webappdata.repository.BeerCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BeerCategoryService {
    private final BeerCategoryRepository beerCategoryRepository;

    public BeerCategory saveCategory(BeerCategory category) {
        return beerCategoryRepository.save(category);
    }

    public Optional<BeerCategory> getCategoryById(Long id) {
        return beerCategoryRepository.findById(id);
    }

    public Optional<BeerCategory> getCategoryByName(String name) {
        return beerCategoryRepository.findByName(name);
    }
}