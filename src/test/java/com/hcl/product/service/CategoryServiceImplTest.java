package com.hcl.product.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hcl.product.dto.CategoryDetailsDto;
import com.hcl.product.entity.Category;
import com.hcl.product.repository.CategoryRepository;

@RunWith(value = SpringJUnit4ClassRunner.class)
public class CategoryServiceImplTest {

	@Mock
	CategoryRepository categoryRepository;
	
	@InjectMocks
	CategoryServiceImpl categoryService;
	
	CategoryDetailsDto categoryDetailsDto = null;
	List<CategoryDetailsDto> categoryDetailsDtos = null;
	Category category = null;
	List<Category> categories = null;
	
	@Before
	public void setup() {
		categoryDetailsDto = new CategoryDetailsDto();
		categoryDetailsDto.setCategoryId(1);
		
		categoryDetailsDtos = new ArrayList<CategoryDetailsDto>();
		categoryDetailsDtos.add(categoryDetailsDto);
		
		category = new Category();
		category.setCategoryId(1);
		
		categories = new ArrayList<>();
		categories.add(category);
	}
	
	@Test
	public void categoriesTest() {
		Mockito.when(categoryRepository.findAll()).thenReturn(categories);
		List<CategoryDetailsDto> responseEntity = categoryService.categories();
		assertEquals(1, responseEntity.size());
	}
	
}
