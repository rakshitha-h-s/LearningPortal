package com.effigo.LearningPortal.service.impl;

import java.util.List;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.effigo.LearningPortal.dto.mapper.CategoryEntityMapper;
import com.effigo.LearningPortal.dto.mapper.UserEntityMapper;
import com.effigo.LearningPortal.dto.request.CategoryEntityrequest;
import com.effigo.LearningPortal.dto.response.CategoryEntityresponse;
import com.effigo.LearningPortal.entity.CategoryEntity;
import com.effigo.LearningPortal.entity.UserEntity;
import com.effigo.LearningPortal.repository.CategoryEntityRepository;
import com.effigo.LearningPortal.repository.UserEntityRepository;
import com.effigo.LearningPortal.service.CategoryService;

import jakarta.transaction.Transactional;
@Service
@Transactional
public class CategoryServiceImpl implements CategoryService{
	private final CategoryEntityRepository categoryRepository;
	public CategoryServiceImpl(CategoryEntityRepository categoryRepository)
	{
		this.categoryRepository=categoryRepository;
	}
	@Override
	public List<CategoryEntity> findAllCategory() {
		// TODO Auto-generated method stub
		return categoryRepository.findAll();
	}

	@Override
	public Optional<CategoryEntity> findById(Long id) {
		// TODO Auto-generated method stub
		return categoryRepository.findById(id);
	}


	@Override
	public void deleteCategoryentity(Long id) {
		categoryRepository.deleteById(id);
	}

	@Override
	public CategoryEntityresponse saveCategoryEntity(CategoryEntityrequest userentityrequest) {
		// TODO Auto-generated method stub
		CategoryEntity userEntity = CategoryEntityMapper.MAPPER.fromRequestToEntity(userentityrequest);
        categoryRepository.save(userEntity);
        return CategoryEntityMapper.MAPPER.fromEntityToResponse(userEntity);
	}

	@Override
	public CategoryEntityresponse updateCategoryEntity(CategoryEntityrequest userentityrequest, Long id) {
		// TODO Auto-generated method stub
		Optional<CategoryEntity> checkExistinguser = findById(id);
        if (! checkExistinguser.isPresent())
            throw new RuntimeException("Category Id "+ id + " Not Found!");

        CategoryEntity userEntity = CategoryEntityMapper.MAPPER.fromRequestToEntity(userentityrequest);
        //UserEntity.setId(id);
       categoryRepository.save(userEntity);
        return CategoryEntityMapper.MAPPER.fromEntityToResponse(userEntity);
	}

}
