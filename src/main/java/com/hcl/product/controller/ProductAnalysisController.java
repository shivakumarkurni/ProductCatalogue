package com.hcl.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.product.dto.ProductAnalysisDTO;
import com.hcl.product.service.ProductAnalysisServiceImpl;

/**
 * @author Shiva
 * 
 * This class will return records based on day wise,weekly,monthly
 * 
 *
 */

@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
@RestController
public class ProductAnalysisController {

	@Autowired
	ProductAnalysisServiceImpl productAnalysisServiceImpl;
	

	/**
	 * @param data type string
	 * 
	 * This method returns list of ProductAnalysisDTO objects
	 * 
	 * @return ProductAnalysisDTO contains productId,productName,count of products
	 * 
	 *
	 */

	@GetMapping("/analysis/{report}")
	public ResponseEntity<List<ProductAnalysisDTO>> getAnalysisReport(@PathVariable String report) {

		return new ResponseEntity<>(productAnalysisServiceImpl.analysisReport(report), HttpStatus.OK);
	}

}
