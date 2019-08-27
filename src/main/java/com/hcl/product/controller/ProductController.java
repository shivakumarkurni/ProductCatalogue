package com.hcl.product.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.product.dto.ProductDetailsDto;
import com.hcl.product.dto.ProductDto;
import com.hcl.product.service.ProductService;

/***
 * 
 * @author Anuradha
 *
 */
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
@RequestMapping("/bank")
@RestController
public class ProductController {
	
	private static Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	ProductService productService;
	
	@GetMapping("/products/{categoryId}")
	public ResponseEntity<List<ProductDto>> products(@PathVariable("categoryId") Integer categoryId) {
		logger.info("ProductController :: categoryId :{} " , categoryId);
		return new ResponseEntity<>(productService.products(categoryId), HttpStatus.OK);
	}
	
	@GetMapping("/productdetails/{productId}")
	public ResponseEntity<ProductDetailsDto> productDetails(@PathVariable("productId") Integer productId) {
		logger.info("ProductController :: productDetails :{} " , productId);
		return new ResponseEntity<>(productService.productDetails(productId), HttpStatus.OK);
	}

}
