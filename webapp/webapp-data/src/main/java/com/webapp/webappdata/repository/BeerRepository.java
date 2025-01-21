package com.webapp.webappdata.repository;

import com.webapp.webappdata.entity.Beer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BeerRepository extends JpaRepository<Beer, String> {
    Optional<Beer> findBySku(String sku);
    boolean existsBySku(String sku);
    List<Beer> findByNameContainingIgnoreCase(String name);
    List<Beer> findByBreweryNameContainingIgnoreCase(String breweryName);
    List<Beer> findByCategoryNameContainingIgnoreCase(String categoryName);
}