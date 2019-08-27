package com.hcl.product.controller;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hcl.product.dto.CategoryDetailsDto;
import com.hcl.product.service.CategoryService;

@RunWith(value = SpringJUnit4ClassRunner.class)
public class CategoryControllerTest {

	@Mock
	CategoryService categoryService;
	
	@InjectMocks
	CategoryController categoryController;
	
	CategoryDetailsDto categoryDetailsDto = null;
	List<CategoryDetailsDto> categoryDetailsDtos = null;
	
	@Before
	public void setup() {
		categoryDetailsDto = new CategoryDetailsDto();
		categoryDetailsDto.setCategoryId(1);
		
		categoryDetailsDtos = new ArrayList<CategoryDetailsDto>();
		categoryDetailsDtos.add(categoryDetailsDto);
	}
	
	@Test
	public void categoriesTest() {
		Mockito.when(categoryService.categories()).thenReturn(categoryDetailsDtos);
		ResponseEntity<List<CategoryDetailsDto>> responseEntity = categoryController.categories();
		List<CategoryDetailsDto> categoryDetailsDtos = responseEntity.getBody();
		assertEquals(1, categoryDetailsDtos.size());
	}

}
