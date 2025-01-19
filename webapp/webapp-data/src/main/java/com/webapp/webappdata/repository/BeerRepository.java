package com.webapp.webappdata.repository;

import com.webapp.webappdata.entity.Beer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BeerRepository extends JpaRepository<Beer, String> {
    List<Beer> findByBreweryId(Long breweryId);
    List<Beer> findByCategoryId(Long categoryId);
    Optional<Beer> findBySku(String sku);
}