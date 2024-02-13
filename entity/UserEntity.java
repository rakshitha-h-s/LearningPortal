package com.effigo.LearningPortal.entity;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
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
public class UserEntity {
	    @Id
	    private Long u_id;
		private String username;
        private String password;	    
	    public Long getU_id() {
			return u_id;
		}

		public void setU_id(Long u_id) {
			this.u_id = u_id;
		}
		@Enumerated(EnumType.STRING)
	    private UserType userType; // Enum: LEARNER, AUTHOR
	    //@Temporal(TemporalType.TIMESTAMP)
	    @CreationTimestamp
	    @Column(name = "created_on", nullable = false, updatable = false)
	    private LocalDateTime createdOn;
	    public UserType getUserType() {
			return userType;
		}

		public void setUserType(UserType userType) {
			this.userType = userType;
		}
		//@Temporal(TemporalType.TIMESTAMP)
		@UpdateTimestamp
	    @Column(name = "updated_on", nullable = false)
	    private LocalDateTime updatedOn;

	   /* @PrePersist
	    public void onCreate() {
	    	//DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm");
	    	createdOn =  LocalDateTime.now();
	        updatedOn = createdOn;
	    }

	    @PreUpdate
	    public void onUpdate() {
	        updatedOn =LocalDateTime.now();
	    }*/
		@PrePersist
	    public void onCreate() {
	        // Set the createdOn field with the desired format
	        this.createdOn = LocalDateTime.now();
	    }

	    // Getter and Setter for createdOn field
	    public LocalDateTime getCreatedOn() {
	        return createdOn;
	    }

	    public void setCreatedOn(LocalDateTime createdOn) {
	        this.createdOn = createdOn;
	    }

	    // Custom method to get createdOn field in "MM/DD/YYYY HH:MM" format
	    public String getFormattedCreatedOn() {
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm");
	        return createdOn.format(formatter);
	    }

	    // Helper method to format LocalDateTime to string
	    private String formatDateTime(LocalDateTime dateTime) {
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm");
	        return dateTime.format(formatter);
	    }
	public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}
	public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}
	public enum UserType {
	    ADMIN,
	    AUTHOR,
	    LEARNER
	}

}

