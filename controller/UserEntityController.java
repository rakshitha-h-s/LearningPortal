package com.effigo.LearningPortal.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.effigo.LearningPortal.dto.request.CourseEntityrequest;
import com.effigo.LearningPortal.dto.request.UserEntityrequest;
import com.effigo.LearningPortal.dto.response.CourseEntityResponse;
import com.effigo.LearningPortal.dto.response.UserEntityresponse;
import com.effigo.LearningPortal.entity.UserEntity;
import com.effigo.LearningPortal.entity.UserEntity.UserType;
import com.effigo.LearningPortal.service.CourseService;
import com.effigo.LearningPortal.service.UserEntityService;
import com.effigo.LearningPortal.service.impl.UserEntityServiceImpl;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
@RestController
@RequestMapping("/userentity")
public class UserEntityController {
	private final UserEntityService userService;
	private final CourseService courseservice;
	public UserEntityController(UserEntityService userService,CourseService courseservice) {
		this.userService = userService;
		this.courseservice=courseservice;
	}
	@GetMapping
	public List<UserEntity> findAllUser()
	{
		return userService.findAllUser();
	}
	@GetMapping("/{u_id}")
	public Optional<UserEntity> findById(@PathVariable("u_id") Long id){
		return userService.findById(id);
	}
	
	@DeleteMapping("/{id}")
	public void deleteUserEntity(@PathVariable("id") Long id) {
		userService.deleteUserentity(id);
	}
	@PostMapping("/res")
	public UserEntityresponse saveUserEntityResponse(@RequestBody UserEntityrequest userRequest) {
		return userService.saveUserEntity(userRequest);
	}
	
	@PutMapping("/update/{id}")
	public UserEntityresponse updateUserEntity(@RequestBody UserEntityrequest userRequest,@PathVariable("id") Long id)
	{
		return userService.updateUserEntity(userRequest, id);
	}
	@PostMapping("/{usertype}/{id}/{password}")
	public UserEntityresponse saveUserEntityResponse1(@RequestBody UserEntityrequest userRequest,@PathVariable("usertype") UserType usertype,@PathVariable("id") Long id,@PathVariable("password") String password) {
		return userService.saveUserEntity1(userRequest,usertype,id,password);
	}
	@PostMapping("/addcourse/{usertype}/{id}/{password}")
	public CourseEntityResponse saveCourseEntityResponse(@RequestBody CourseEntityrequest userrequest,@PathVariable("usertype") UserType usertype,@PathVariable("id") Long id,@PathVariable("password") String password) {
		return userService.saveCourseEntity1(userrequest,usertype,id,password);
	}
	@PostMapping("/updatecourse/{usertype}/{id}/{password}/{courseid}")
	public CourseEntityResponse updateCourseEntityResponse(@RequestBody CourseEntityrequest userrequest,@PathVariable("usertype") UserType usertype,@PathVariable("id") Long id,@PathVariable("password") String password,@PathVariable("courseid") Long courseid) {
		return userService.updateCourseEntity1(userrequest, usertype, id, password, courseid);
	}
}
