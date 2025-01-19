package com.webapp.webappdata.mapper;

import com.webapp.webappdata.dto.api.BeerDTO;
import com.webapp.webappdata.dto.response.BeerDetailsDTO;
import com.webapp.webappdata.entity.Beer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BeerMapper {

    @Mapping(source = "sku", target = "sku")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "abv", target = "abv")
    @Mapping(source = "ibu", target = "ibu")
    @Mapping(source = "tastingNotes", target = "tastingNotes")
    @Mapping(source = "foodPairing", target = "foodPairing")
    @Mapping(source = "suggestedGlassware", target = "suggestedGlassware")
    @Mapping(source = "servingTempF", target = "servingTempF")
    @Mapping(source = "servingTempC", target = "servingTempC")
    @Mapping(source = "features", target = "features")
    @Mapping(target = "brewery", ignore = true)
    @Mapping(target = "category", ignore = true)
    @Mapping(target = "reviews", ignore = true)
    Beer toEntity(BeerDTO dto);

    BeerDetailsDTO toDetailsDto(Beer beer);
}