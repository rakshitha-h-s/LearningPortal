package com.effigo.LearningPortal.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.effigo.LearningPortal.dto.mapper.UserCourseEnrollmentMapper;
import com.effigo.LearningPortal.dto.request.UserCourseEnrollmentrequest;
import com.effigo.LearningPortal.dto.response.UserCourseEnrollmentresponse;
import com.effigo.LearningPortal.entity.UserCourseEnrollmentEntity;
import com.effigo.LearningPortal.repository.UserCourseEnrollmentRepository;
import com.effigo.LearningPortal.service.UserCourseEnrollmentService;

import jakarta.transaction.Transactional;
@Service
@Transactional
public class UserCourseEnrollmentServiceImpl implements UserCourseEnrollmentService{
	private final UserCourseEnrollmentRepository usercourseenrollmentRepository;
	public UserCourseEnrollmentServiceImpl(UserCourseEnrollmentRepository usercourseenrollmentRepository)
	{
		this.usercourseenrollmentRepository=usercourseenrollmentRepository;
	}
	@Override
	public List<UserCourseEnrollmentEntity> findAllCourseEnrollment() {
		// TODO Auto-generated method stub
		return usercourseenrollmentRepository.findAll();
	}

	@Override
	public Optional<UserCourseEnrollmentEntity> findById(Long id) {
		// TODO Auto-generated method stub
		return usercourseenrollmentRepository.findById(id);
	}


	@Override
	public void deleteUserCourseEnrollmententity(Long id) {
		// TODO Auto-generated method stub
		usercourseenrollmentRepository.deleteById(id);
	}

	@Override
	public UserCourseEnrollmentresponse saveUserCourseEnrollmentEntity(
			UserCourseEnrollmentrequest usercourseenrollmententityrequest) {
		UserCourseEnrollmentEntity userEntity = UserCourseEnrollmentMapper.MAPPER.fromRequestToEntity(usercourseenrollmententityrequest);
        usercourseenrollmentRepository.save(userEntity);
        return UserCourseEnrollmentMapper.MAPPER.fromEntityToResponse(userEntity);
	}

	@Override
	public UserCourseEnrollmentresponse updateUserCourseEnrollmentEntity(
			UserCourseEnrollmentrequest usercourseentityrequest, Long id) {
		// TODO Auto-generated method stub
		Optional<UserCourseEnrollmentEntity> checkExistinguser = findById(id);
        if (! checkExistinguser.isPresent())
            throw new RuntimeException("course enrollment Id "+ id + " Not Found!");

        UserCourseEnrollmentEntity userEntity = UserCourseEnrollmentMapper.MAPPER.fromRequestToEntity(usercourseentityrequest);
        //UserEntity.setId(id);
        usercourseenrollmentRepository.save(userEntity);
        return UserCourseEnrollmentMapper.MAPPER.fromEntityToResponse(userEntity);
	}

}
