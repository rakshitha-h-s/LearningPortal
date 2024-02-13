package com.effigo.LearningPortal.service;

import java.util.List;
import java.util.Optional;

import com.effigo.LearningPortal.dto.request.CourseEntityrequest;
import com.effigo.LearningPortal.dto.request.FavoriteEntityrequest;
import com.effigo.LearningPortal.dto.request.UserEntityrequest;
import com.effigo.LearningPortal.dto.response.CourseEntityResponse;
import com.effigo.LearningPortal.dto.response.FavoriteEntityresponse;
import com.effigo.LearningPortal.dto.response.UserEntityresponse;
import com.effigo.LearningPortal.entity.UserEntity;
import com.effigo.LearningPortal.entity.UserEntity.UserType;

public interface UserEntityService {
List<UserEntity> findAllUser();
Optional<UserEntity> findById(Long id);
void deleteUserentity(Long id);
UserEntityresponse saveUserEntity(UserEntityrequest userentityrequest);
UserEntityresponse updateUserEntity(UserEntityrequest userentityrequest,Long id);
UserEntityresponse saveUserEntity1(UserEntityrequest userentityrequest,UserType usertype,Long id,String password);
}
}

