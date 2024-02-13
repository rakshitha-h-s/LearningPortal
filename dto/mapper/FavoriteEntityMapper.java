package com.effigo.LearningPortal.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.mapstruct.Mappings;
import com.effigo.LearningPortal.dto.request.CategoryEntityrequest;
import com.effigo.LearningPortal.dto.request.FavoriteEntityrequest;
import com.effigo.LearningPortal.dto.response.FavoriteEntityresponse;
import com.effigo.LearningPortal.entity.FavoriteEntity;
@Mapper
public interface FavoriteEntityMapper {
	FavoriteEntityMapper MAPPER =Mappers.getMapper(FavoriteEntityMapper.class);
	FavoriteEntity fromRequestToEntity(FavoriteEntityrequest faventityRequest);
	FavoriteEntityresponse fromEntityToResponse(FavoriteEntity favEntity);
	/*FavoriteEntityMapper INSTANCE = Mappers.getMapper(FavoriteEntityMapper.class);

    @Mappings({
        @Mapping(source = "course_id", target = "course_id"), // Map the course_id field
      // @Mapping(target = "otherField", ignore = true) // Ignore other fields in FavoriteEntityResponse
        // Add more ignore mappings if there are other fields you don't want to map
    })
    FavoriteEntityresponse mapCourseIdToFavoriteEntityResponse(CategoryEntityrequest courserequest);*/

}
