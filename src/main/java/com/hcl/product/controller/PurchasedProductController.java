package com.hcl.product.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.product.dto.PurchasedProductDto;
import com.hcl.product.dto.PurchasedDetailsDto;
import com.hcl.product.service.PurchasedProductService;

@RestController
@RequestMapping("/bank")
@CrossOrigin(origins = {"*","*/"},allowedHeaders = {"*","*/"})
public class PurchasedProductController {

	private static final Logger LOGGER = LoggerFactory.getLogger(PurchasedProductController.class);
	
	@Autowired
	PurchasedProductService purchasedProductService;
	
	@PostMapping("/buyProduct")
	public ResponseEntity<PurchasedDetailsDto> buyProduct(@RequestBody PurchasedProductDto buyProductDto){
		LOGGER.debug("PurchasedProductController buyProduct()");
		PurchasedDetailsDto productDetailsDto = purchasedProductService.buyProduct(buyProductDto);
		return new ResponseEntity<PurchasedDetailsDto>(productDetailsDto,HttpStatus.CREATED);
	}
}
