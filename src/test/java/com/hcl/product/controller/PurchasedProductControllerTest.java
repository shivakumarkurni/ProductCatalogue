package com.hcl.product.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hcl.product.dto.PurchasedDetailsDto;
import com.hcl.product.dto.PurchasedProductDto;
import com.hcl.product.service.PurchasedProductService;

@RunWith(value = SpringJUnit4ClassRunner.class)
public class PurchasedProductControllerTest {

	@Mock
	PurchasedProductService purchasedProductService;
	
	@InjectMocks
	PurchasedProductController purchasedProductController;
	
	PurchasedDetailsDto purchasedDetailsDto = null;
	PurchasedProductDto purchasedProductDto = null;
	
	@Before
	public void setup() {
		purchasedDetailsDto = new PurchasedDetailsDto();
		purchasedDetailsDto.setStatusCode(201);
		purchasedProductDto = new PurchasedProductDto();
		purchasedProductDto.setName("lakshmi");
	}
	
	@Test
	public void buyProductTest() {
		Mockito.when(purchasedProductService.buyProduct(purchasedProductDto)).thenReturn(purchasedDetailsDto);
		ResponseEntity<PurchasedDetailsDto> responseEntity = purchasedProductController.buyProduct(purchasedProductDto);
		PurchasedDetailsDto puDetailsDto = responseEntity.getBody();
		assertEquals(purchasedDetailsDto.getStatusCode(), puDetailsDto.getStatusCode());
	}

}
