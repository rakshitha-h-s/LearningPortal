package com.effigo.LearningPortal.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.effigo.LearningPortal.entity.UserEntity;
@Repository
public interface UserEntityRepository extends JpaRepository<UserEntity,Long>{

}
