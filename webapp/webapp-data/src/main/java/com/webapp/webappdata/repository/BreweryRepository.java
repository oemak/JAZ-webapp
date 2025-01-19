package com.webapp.webappdata.repository;

import com.webapp.webappdata.entity.Brewery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BreweryRepository extends JpaRepository<Brewery, Long> {
    Optional<Brewery> findByName(String name);
}