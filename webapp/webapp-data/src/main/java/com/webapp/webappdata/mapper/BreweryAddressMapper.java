package com.webapp.webappdata.mapper;

import com.webapp.webappdata.dto.response.BreweryAddressDTO;
import com.webapp.webappdata.entity.BreweryAddress;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BreweryAddressMapper {
    @Mapping(source = "city", target = "city")
    @Mapping(source = "state", target = "state")
    @Mapping(source = "country", target = "country")
    BreweryAddress toEntity(BreweryAddressDTO dto);

    BreweryAddressDTO toDto(BreweryAddress address);
}