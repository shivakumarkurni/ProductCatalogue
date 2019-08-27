package com.hcl.product.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.product.dto.CategoryDetailsDto;
import com.hcl.product.entity.Category;
import com.hcl.product.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

	private static final Logger LOGGER = LoggerFactory.getLogger(CategoryServiceImpl.class);
	
	@Autowired
	CategoryRepository categoryRepository;

	public List<CategoryDetailsDto> categories() {
		LOGGER.debug("CategoryServiceImpl categories()");
		List<CategoryDetailsDto> categoryDetailsDtos = new ArrayList<>();
		List<Category> categories = categoryRepository.findAll();

		for (Category category : categories) {
			CategoryDetailsDto categoryDetailsDto = new CategoryDetailsDto();
			BeanUtils.copyProperties(category, categoryDetailsDto);
			categoryDetailsDtos.add(categoryDetailsDto);
		}

		return categoryDetailsDtos;
	}

}
