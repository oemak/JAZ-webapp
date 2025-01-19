package com.webapp.webappdata.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "breweries")
@Data
public class Brewery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String region;
    private String country;

    // Brewery -> Beer
    @OneToMany(mappedBy = "brewery")
    private List<Beer> beers = new ArrayList<>();

    // Brewery -> BreweryAddress
    @OneToOne(mappedBy = "brewery", cascade = CascadeType.ALL)
    private BreweryAddress address;
}