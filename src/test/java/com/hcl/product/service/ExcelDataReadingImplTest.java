package com.hcl.product.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.multipart.MultipartFile;

import com.hcl.product.dto.FileUploadExcelDto;
import com.hcl.product.dto.ResponseDto;
import com.hcl.product.entity.Category;
import com.hcl.product.entity.Product;
import com.hcl.product.repository.CategoryRepository;
import com.hcl.product.repository.ProductRepository;


@RunWith(MockitoJUnitRunner.class)
public class ExcelDataReadingImplTest {
	
	@InjectMocks ExcelDataReadingImpl excelDataReadingImpl;
	
	@Mock
	CategoryRepository categoryRepository;
	@Mock
	ProductRepository productRepository;

	@Mock
	
	Category category = null;
	List<Category> categories = null;
	
	Product product = null;
	List<Product> products = null;
	MultipartFile reapExcelDataFile;
	
	FileUploadExcelDto fileUploadExcelDto;
	
	List<FileUploadExcelDto> tempStudentList;
	@Before
	public void setup() {
		
		category = new Category();
		category.setCategoryId(1);
		category.setCategoryName("product1");
		
		
		categories = new ArrayList<>();
		categories.add(category);
		
		product = new Product();
		product.setProductId(1);
		product.setProductName("Fund Transfer");
		
		products = new ArrayList<>();
		products.add(product);
		
		fileUploadExcelDto=new FileUploadExcelDto();
		fileUploadExcelDto.setCateloge(category.getCategoryName());
		fileUploadExcelDto.setCharge(product.getProductCharge());
		fileUploadExcelDto.setDiscription(product.getProductDesc());
		fileUploadExcelDto.setProduct(product.getProductName());
		tempStudentList=new ArrayList<>();
		
		tempStudentList.add(fileUploadExcelDto);
		
	}
	

	
	
	@Test 
	public void excelDataStoreToDatabaseTest2() throws IOException {
		
		Mockito.when(categoryRepository.findByCategoryName(category.getCategoryName())).thenReturn(categories);
		Mockito.when(productRepository.findByProductNameAndCategoryId(product.getProductName(), category.getCategoryId())).thenReturn(products);
		Mockito.when(productRepository.save(product)).thenReturn(product);
		Mockito.when(categoryRepository.save(category)).thenReturn(category);
		
		ResponseDto actual = excelDataReadingImpl.excelDataStoreToDatabase2(tempStudentList);
		
		Assert.assertEquals(201, actual.getStatusCode().intValue());

	}
	
	
	@Test
	public void excelDataStoreToDatabaseTest3() throws IOException {
		categories=new ArrayList<>();
		categories.add(category);
		Mockito.when(categoryRepository.findByCategoryName(category.getCategoryName())).thenReturn(categories);
		Mockito.when(productRepository.findByProductNameAndCategoryId(product.getProductName(), category.getCategoryId())).thenReturn(products);
		Mockito.when(productRepository.save(product)).thenReturn(product);
		Mockito.when(categoryRepository.save(category)).thenReturn(category);
		
		ResponseDto actual = excelDataReadingImpl.excelDataStoreToDatabase2(tempStudentList);
		
		Assert.assertEquals(201, actual.getStatusCode().intValue());

	

}
}
