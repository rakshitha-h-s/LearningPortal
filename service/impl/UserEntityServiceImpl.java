package com.effigo.LearningPortal.service.impl;

import com.effigo.LearningPortal.dto.mapper.CourseEntityMapper;
import com.effigo.LearningPortal.dto.mapper.FavoriteEntityMapper;
import com.effigo.LearningPortal.dto.mapper.UserEntityMapper;
import com.effigo.LearningPortal.dto.request.CourseEntityrequest;
import com.effigo.LearningPortal.dto.request.UserEntityrequest;
import com.effigo.LearningPortal.dto.response.CourseEntityResponse;
import com.effigo.LearningPortal.dto.response.FavoriteEntityresponse;
import com.effigo.LearningPortal.dto.response.UserEntityresponse;
import com.effigo.LearningPortal.entity.CourseEntity;
import com.effigo.LearningPortal.entity.UserEntity;
import com.effigo.LearningPortal.entity.UserEntity.UserType;
import com.effigo.LearningPortal.repository.CourseEntityRepository;
import com.effigo.LearningPortal.repository.FavoriteEntityRepository;
import com.effigo.LearningPortal.repository.UserEntityRepository;
import com.effigo.LearningPortal.service.CourseService;
import com.effigo.LearningPortal.service.UserEntityService;

import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
@Transactional
public class UserEntityServiceImpl implements UserEntityService{
	private final UserEntityRepository userentityRepository;
	private final CourseEntityRepository courseentityrepository;
	private static final Logger logger = LoggerFactory.getLogger(UserEntityServiceImpl.class);
	private final CourseService courseService;
	private final FavoriteEntityRepository favoriteentity;
	public UserEntityServiceImpl(UserEntityRepository userentityRepository, CourseEntityRepository courseentityrepository,CourseService courseservice,FavoriteEntityRepository favoriteentity)
	{
		this.userentityRepository=userentityRepository;
		this.courseentityrepository = courseentityrepository;
		this.courseService=courseservice;
		this.favoriteentity = favoriteentity;
	}
	@Override
	public List<UserEntity> findAllUser() {
		// TODO Auto-generated method stub
		return userentityRepository.findAll();
	}

	@Override
	public Optional<UserEntity> findById(Long id) {
		// TODO Auto-generated method stub
		return userentityRepository.findById(id);
	}


	@Override
	public void deleteUserentity(Long id) {
		// TODO Auto-generated method stub
		userentityRepository.deleteById(id);
	}
	@Override
	public UserEntityresponse saveUserEntity(UserEntityrequest userentityrequest) {
		// TODO Auto-generated method stub
		
		UserEntity userEntity = UserEntityMapper.MAPPER.fromRequestToEntity(userentityrequest);
        userentityRepository.save(userEntity);
        return UserEntityMapper.MAPPER.fromEntityToResponse(userEntity);
	}

	@Override
	public UserEntityresponse updateUserEntity(UserEntityrequest userentityrequest, Long id) {
		// TODO Auto-generated method stub
		Optional<UserEntity> checkExistinguser = findById(id);
        if (! checkExistinguser.isPresent())
            throw new RuntimeException("User Id "+ id + " Not Found!");

        UserEntity userEntity = UserEntityMapper.MAPPER.fromRequestToEntity(userentityrequest);
        userentityRepository.save(userEntity);
        return UserEntityMapper.MAPPER.fromEntityToResponse(userEntity);
	}

    @Override
    public UserEntityresponse saveUserEntity1(UserEntityrequest userentityrequest,UserType usertype,Long id,String password)
    {
    	   if (usertype != UserType.ADMIN) {
               throw new IllegalArgumentException("Only ADMIN users are allowed to perform this operation.");
           }
           // Fetch the user from the database
           Optional<UserEntity> userOptional = userentityRepository.findById(id);
           UserEntity user = userOptional.get();
           // Check if the user exists
           if (user.getU_id()!=id) {
               throw new IllegalArgumentException("ADMIN with ID " + id + " not found.");
           }
           // Check if the UserType of the user matches ADMIN     
           if (user.getUserType() != UserType.ADMIN) {
               throw new IllegalArgumentException("User with ID " + id + " is not an admin user.");
           }
           if(!user.getPassword().equals(password)) {
        	   throw new IllegalArgumentException("Password of ADMIN is incorrect");
           }
         UserEntity userEntity = UserEntityMapper.MAPPER.fromRequestToEntity(userentityrequest);
         userentityRepository.save(userEntity);
         return UserEntityMapper.MAPPER.fromEntityToResponse(userEntity);
    }
    @Override
    public CourseEntityResponse saveCourseEntity1(CourseEntityrequest courserequest,UserType usertype,Long id,String password) {
    	if (usertype != UserType.AUTHOR) {
            throw new IllegalArgumentException("Only ADMIN users are allowed to perform this operation.");
        }
        // Fetch the user from the database
        Optional<UserEntity> userOptional = userentityRepository.findById(id);
        UserEntity user = userOptional.get();
        // Check if the user exists
        if (user.getU_id()!=id) {
            throw new IllegalArgumentException("AUTHOR with ID " + id + " not found.");
        }
        // Check if the UserType of the user matches ADMIN     
        if (user.getUserType() != UserType.AUTHOR) {
            throw new IllegalArgumentException("User with ID " + id + " is not an author user.");
        }
        if(!user.getPassword().equals(password)) {
     	   throw new IllegalArgumentException("Password of AUTHOR is incorrect");
        }
        CourseEntity userEntity = CourseEntityMapper.MAPPER.fromRequestToEntity(courserequest);
        courseentityrepository.save(userEntity);
        return CourseEntityMapper.MAPPER.fromEntityToResponse(userEntity);	
    }
    public CourseEntityResponse updateCourseEntity1(CourseEntityrequest courserequest,UserType usertype,Long id,String password,Long courseid) {
    	if (usertype != UserType.AUTHOR) {
            throw new IllegalArgumentException("Only ADMIN users are allowed to perform this operation.");
        }
        // Fetch the user from the database
        Optional<UserEntity> userOptional = userentityRepository.findById(id);
        UserEntity user = userOptional.get();
        // Check if the user exists
        if (user.getU_id()!=id) {
            throw new IllegalArgumentException("AUTHOR with ID " + id + " not found.");
        }
        // Check if the UserType of the user matches ADMIN     
        if (user.getUserType() != UserType.AUTHOR) {
            throw new IllegalArgumentException("User with ID " + id + " is not an author user.");
        }
        if(!user.getPassword().equals(password)) {
     	   throw new IllegalArgumentException("Password of AUTHOR is incorrect");
        }
        Optional<CourseEntity> checkExistinguser = courseentityrepository.findById(courseid);
        if (! checkExistinguser.isPresent())
            throw new RuntimeException("Course Id "+ courseid + " Not Found!");

        CourseEntity userEntity = CourseEntityMapper.MAPPER.fromRequestToEntity(courserequest);
        courseentityrepository.save(userEntity);
        return CourseEntityMapper.MAPPER.fromEntityToResponse(userEntity);
    }

    /*@Override
    public FavoriteEntityresponse saveFavoriteEntity(CourseEntityrequest courserequest,UserType usertype,Long id,String coursename)
    {
    	Long courseId = courseService.getCourseIdByCoursename(coursename);
    	Optional<CourseEntity> checkExistinguser = courseentityrepository.findById(courseId);
    	CourseEntity course=checkExistinguser.get();
        FavoriteEntityresponse favoriteResponse = FavoriteEntityMapper.mapCourseIdToFavoriteEntityResponse(course);
        // Perform additional logic or actions if needed
        
        return favoriteResponse;
    	
    }*/
}

	

