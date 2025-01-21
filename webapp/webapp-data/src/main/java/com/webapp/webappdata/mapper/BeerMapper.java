package com.webapp.webappdata.mapper;

import com.webapp.webappdata.dto.api.BeerDTO;
import com.webapp.webappdata.dto.response.BeerDetailsDTO;
import com.webapp.webappdata.entity.Beer;
import com.webapp.webappdata.entity.BeerCategory;
import com.webapp.webappdata.entity.Brewery;
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
    @Mapping(source = "brewery", target = "brewery")
    @Mapping(source = "category", target = "category")
    @Mapping(target = "reviews", ignore = true)
    Beer toEntity(BeerDTO dto);

    @Mapping(target = "averageRating", ignore = true)
    @Mapping(source = "reviews", target = "reviews")
    BeerDetailsDTO toDetailsDto(Beer beer);

    default Brewery mapBrewery(String breweryName) {
        if (breweryName == null) {
            return null;
        }
        Brewery brewery = new Brewery();
        brewery.setName(breweryName);
        return brewery;
    }

    default BeerCategory mapCategory(String categoryName) {
        if (categoryName == null) {
            return null;
        }
        BeerCategory category = new BeerCategory();
        category.setName(categoryName);
        return category;
    }
}