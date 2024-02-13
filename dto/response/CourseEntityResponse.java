package com.effigo.LearningPortal.dto.response;

import java.io.Serializable;

import com.effigo.LearningPortal.entity.CategoryEntity;
import com.effigo.LearningPortal.entity.UserEntity;

import lombok.Data;
@Data
public class CourseEntityResponse implements Serializable{
	private Long course_id;
	public CourseEntityResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getCourse_id() {
		return course_id;
	}
	public void setCourse_id(Long course_id) {
		this.course_id = course_id;
	}
	public String getCourse_name() {
		return course_name;
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	public CategoryEntity getCategory() {
		return category;
	}
	public void setCategory(CategoryEntity category) {
		this.category = category;
	}
	public UserEntity getU_id() {
		return u_id;
	}
	public void setU_id(UserEntity u_id) {
		this.u_id = u_id;
	}
	private String course_name;
    private CategoryEntity category;
    private UserEntity u_id;


}
