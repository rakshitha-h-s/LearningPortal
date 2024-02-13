package com.effigo.LearningPortal.entity;

import java.sql.Date;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.effigo.LearningPortal.entity.CategoryEntity.CategoryType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class CategoryEntity {
	@Id
	private Long category_id;
	public Long getCategory_id() {
		return category_id;
	}

	public void setCategory_id(Long category_id) {
		this.category_id = category_id;
	}
	@Enumerated(EnumType.STRING)
    private CategoryType category_Type; 
	@CreationTimestamp
    @Column(name = "created_on", nullable = false, updatable = false)
    private LocalDateTime createdOn;
    @UpdateTimestamp
    @Column(name = "updated_on", nullable = false)
    private LocalDateTime updatedOn;
	//private String category_Type1;
    /*
	@PrePersist
    public void onCreate() {
    	createdOn =  LocalDateTime.now();
        updatedOn = createdOn;
    }

    @PreUpdate
    public void onUpdate() {
        updatedOn =LocalDateTime.now();
    }*/

	public CategoryType getCategory_Type() {
		return category_Type;
	}

	public void setCategory_Type(CategoryType category_Type) {
		this.category_Type = category_Type;
	}
	public enum CategoryType {
    JAVA,
    SQL,
    OOPS,
    SPA
}	
}
