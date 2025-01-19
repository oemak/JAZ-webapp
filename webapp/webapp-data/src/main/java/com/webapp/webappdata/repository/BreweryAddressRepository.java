package com.webapp.webappdata.repository;

import com.webapp.webappdata.entity.BreweryAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BreweryAddressRepository extends JpaRepository<BreweryAddress, Long> {
    Optional<BreweryAddress> findByBreweryId(Long breweryId);
}