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

import com.hcl.product.dto.ProductDetailsDto;
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
	ProductDetailsDto productDetailsDto = null;
	List<ProductDetailsDto> productDetailList = null;

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
		product.setProductCharge(7491.28);
		product.setProductDesc("Fund Transfer Pre Processing");
		
		products = new ArrayList<Product>();
		products.add(product);
		
		productDetailsDto = new ProductDetailsDto();
		productDetailsDto.setProductCharge(7491.28);
		productDetailsDto.setProductDesc("Fund Transfer Pre Processing");
		
		productDetailList = new ArrayList<ProductDetailsDto>();
		productDetailList.add(productDetailsDto);
	}
	
	@Test
	public void productsTest() {
		Mockito.when(productRepository.findByCategoryId(Mockito.anyInt())).thenReturn(products);
		List<ProductDto> responseEntity = productService.products(Mockito.anyInt());
		assertEquals(1, responseEntity.size());
	}
	
	@Test
	public void productDetailsTest() {
		Mockito.when(productRepository.findByProductId(Mockito.anyInt())).thenReturn(product);
		ProductDetailsDto responseEntity = productService.productDetails(Mockito.anyInt());
		assertEquals(productDetailsDto.toString(), responseEntity.toString());
	}
	
}
