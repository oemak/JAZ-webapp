package com.webapp.webappdata.mapper;

import com.webapp.webappdata.dto.request.ReviewCreateRequest;
import com.webapp.webappdata.dto.response.ReviewDTO;
import com.webapp.webappdata.entity.Review;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ReviewDetailsMapper.class})
public interface ReviewMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "beer", ignore = true)
    @Mapping(target = "reviewDetails", source = "details")
    Review toEntity(ReviewCreateRequest dto);

    @Mapping(source = "reviewDetails", target = "details")
    ReviewDTO toDto(Review review);

    List<ReviewDTO> toDtoList(List<Review> reviews);
}