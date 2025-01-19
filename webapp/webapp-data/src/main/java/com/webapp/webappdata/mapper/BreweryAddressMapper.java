package com.webapp.webappdata.mapper;

import com.webapp.webappdata.dto.response.BreweryAddressDTO;
import com.webapp.webappdata.entity.BreweryAddress;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BreweryAddressMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "brewery", ignore = true)
    BreweryAddress toEntity(BreweryAddressDTO dto);

    BreweryAddressDTO toDto(BreweryAddress address);
}