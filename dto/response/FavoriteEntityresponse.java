package com.effigo.LearningPortal.dto.response;

import java.io.Serializable;

import com.effigo.LearningPortal.entity.CourseEntity;
import com.effigo.LearningPortal.entity.UserEntity;

import lombok.Data;
@Data
public class FavoriteEntityresponse implements Serializable{
	public Long getF_id() {
		return f_id;
	}
	public void setF_id(Long f_id) {
		this.f_id = f_id;
	}
	public UserEntity getU_id() {
		return u_id;
	}
	public void setU_id(UserEntity u_id) {
		this.u_id = u_id;
	}
	public CourseEntity getCourse_id() {
		return course_id;
	}
	public void setCourse_id(CourseEntity course_id) {
		this.course_id = course_id;
	}
	private Long f_id;
	private UserEntity u_id;
	public FavoriteEntityresponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	private CourseEntity course_id;

}
