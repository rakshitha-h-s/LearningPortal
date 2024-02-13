package com.effigo.LearningPortal.entity;
import java.sql.Date;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FavoriteEntity {
	@Id
	private Long f_id;
	@ManyToOne
	@JoinColumn(name = "u_id",referencedColumnName="u_id")
	private UserEntity u_id;
	@ManyToOne
	@JoinColumn(name = "course_id",referencedColumnName="course_id")
	private CourseEntity course_id;
	//@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
    @Column(name = "created_on", nullable = false, updatable = false)
    private LocalDateTime createdOn;
	//@Temporal(TemporalType.TIMESTAMP)
	@UpdateTimestamp
    @Column(name = "updated_on", nullable = false)
    private LocalDateTime updatedOn;
	/*@PrePersist
    public void onCreate() {
    	createdOn =  LocalDateTime.now();
        updatedOn = createdOn;
    }

    @PreUpdate
    public void onUpdate() {
        updatedOn =LocalDateTime.now();
    }*/
	
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
}
