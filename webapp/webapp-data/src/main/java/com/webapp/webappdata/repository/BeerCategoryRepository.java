package com.webapp.webappdata.repository;

import com.webapp.webappdata.entity.BeerCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BeerCategoryRepository extends JpaRepository<BeerCategory, Long> {
    Optional<BeerCategory> findByName(String name);
}