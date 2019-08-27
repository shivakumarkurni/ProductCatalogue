package com.hcl.product.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.product.dto.CategoryDetailsDto;
import com.hcl.product.service.CategoryService;

@RestController
@RequestMapping("/bank")
@CrossOrigin(origins = {"*","*/"},allowedHeaders = {"*","*/"})
public class CategoryController {

	private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);
	
	@Autowired
	CategoryService categoryService;
	
	@GetMapping("/categories")
	public ResponseEntity<List<CategoryDetailsDto>> categories(){
		logger.debug("CategoryController categories()");
		List<CategoryDetailsDto> categoryDetailsDtos = categoryService.categories();
		return new ResponseEntity<>(categoryDetailsDtos,HttpStatus.OK);
	}
}
