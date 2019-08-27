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

import com.hcl.product.dto.ProductDto;
import com.hcl.product.entity.Product;
import com.hcl.product.repository.CategoryRepository;
import com.hcl.product.repository.ProductRepository;

/***
 * 
 * @author Anuradha
 *
 */
@RunWith(value = SpringJUnit4ClassRunner.class)
public class ProductServiceImplTest {
	
	@Mock
	ProductRepository productRepository;
	
	@Mock
	CategoryRepository categoryRepository;
	
	@InjectMocks
	ProductServiceImpl productService;
	
	ProductDto productDto = null;
	List<ProductDto> productList = null;
	Product product = null;
	List<Product> products = null;

	@Before
	public void test() {
		productDto = new ProductDto();
		productDto.setProductId(1);
		productDto.setProductName("Fund Transfer");
		
		productList = new ArrayList<ProductDto>();
		productList.add(productDto);
		
		product = new Product();
		product.setProductId(1);
		product.setProductName("Fund Transfer");
		
		products = new ArrayList<>();
		products.add(product);
	}
	
	@Test
	public void productsTest() {
		Mockito.when(productRepository.findByCategoryId(Mockito.anyInt())).thenReturn(products);
		List<ProductDto> responseEntity = productService.products(Mockito.anyInt());
		assertEquals(1, responseEntity.size());
	}
}
