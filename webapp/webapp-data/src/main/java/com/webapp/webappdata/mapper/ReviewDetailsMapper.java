package com.webapp.webappdata.mapper;

import com.webapp.webappdata.dto.request.ReviewDetailsCreateDTO;
import com.webapp.webappdata.dto.response.ReviewDetailsDTO;
import com.webapp.webappdata.entity.ReviewDetails;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ReviewDetailsMapper {
    @Mapping(target = "id", ignore = true)
    ReviewDetails toEntity(ReviewDetailsCreateDTO dto);

    ReviewDetailsDTO toDto(ReviewDetails details);
}