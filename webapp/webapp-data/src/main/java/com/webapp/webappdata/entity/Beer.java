package com.webapp.webappdata.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "beers")
@Data
public class Beer {
    @Id
    private String sku;

    @Column(nullable = false)
    private String name;
    private String description;
    private String abv;
    private String ibu;
    private String tastingNotes;
    private String foodPairing;
    private String suggestedGlassware;
    private String servingTempF;
    private String servingTempC;
    private String features;

    // Beer -> Brewery
    @ManyToOne
    @JoinColumn(name = "brewery_id")
    private Brewery brewery;

    // Beer -> Reviews
    @OneToMany(mappedBy = "beer", cascade = CascadeType.ALL)
    private List<Review> reviews = new ArrayList<>();

    // Beer -> BeerCategory
    @ManyToOne
    @JoinColumn(name = "category_id")
    private BeerCategory category;
}
