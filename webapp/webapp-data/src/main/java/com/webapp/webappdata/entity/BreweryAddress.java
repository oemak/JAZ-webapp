package com.webapp.webappdata.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "brewery_addresses")
@Data
public class BreweryAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    private String city;
    private String state;
    private String postalCode;
    private String country;

    @OneToOne
    @JoinColumn(name = "brewery_id")
    private Brewery brewery;
}
