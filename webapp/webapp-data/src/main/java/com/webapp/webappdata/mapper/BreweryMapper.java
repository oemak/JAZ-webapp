package com.webapp.webappdata.mapper;

import com.webapp.webappdata.dto.response.BreweryDTO;
import com.webapp.webappdata.entity.Brewery;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {BreweryAddressMapper.class})
public interface BreweryMapper {
    BreweryDTO toDto(Brewery brewery);

    @Mapping(target = "beers", ignore = true)
    Brewery toEntity(BreweryDTO dto);
}