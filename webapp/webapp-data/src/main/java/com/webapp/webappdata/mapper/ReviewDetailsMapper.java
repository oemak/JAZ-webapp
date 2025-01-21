package com.webapp.webappdata.mapper;

import com.webapp.webappdata.dto.request.ReviewDetailsRequest;
import com.webapp.webappdata.dto.response.ReviewDetailsDTO;
import com.webapp.webappdata.entity.ReviewDetails;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ReviewDetailsMapper {
    @Mapping(target = "review", ignore = true)
    @Mapping(target = "purchaseDate", ignore = true)
    @Mapping(source = "appearanceRating", target = "appearanceRating")
    @Mapping(source = "aromaRating", target = "aromaRating")
    @Mapping(source = "tasteRating", target = "tasteRating")
    @Mapping(source = "purchaseLocation", target = "purchaseLocation")
    ReviewDetails toEntity(ReviewDetailsRequest dto);

    ReviewDetailsDTO toDto(ReviewDetails details);
}