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

import com.hcl.product.dto.ProductDto;
import com.hcl.product.service.ProductService;

@RunWith(value = SpringJUnit4ClassRunner.class)
public class ProductControllerTest {
	
	@Mock
	ProductService productService;
	
	@InjectMocks
	ProductController productController;
	
	ProductDto productDto = null;
	List<ProductDto> productList = null;

	@Before
	public void test() {
		productDto = new ProductDto();
		productDto.setProductId(1);
		productDto.setProductName("Fund Transfer");
		
		productList = new ArrayList<ProductDto>();
		productList.add(productDto);
	}

	@Test
	public void productsTest() {
		Mockito.when(productService.products(Mockito.anyInt())).thenReturn(productList);
		ResponseEntity<List<ProductDto>> responseEntity = productController.products(Mockito.anyInt());
		List<ProductDto> productDto = responseEntity.getBody();
		assertEquals(1, productDto.size());
	}
}
