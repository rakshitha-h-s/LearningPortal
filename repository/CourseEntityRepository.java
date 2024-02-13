package com.effigo.LearningPortal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.effigo.LearningPortal.entity.CourseEntity;
@Repository
public interface CourseEntityRepository extends JpaRepository<CourseEntity,Long> {

	//Long findCourseIdByCoursename(String title);
	/*@Query("SELECT c.course_id FROM course_entity c WHERE c.course_name = :course_name")
    Long findCourseIdByCoursename(@Param("course_name") String course_name);*/
}
