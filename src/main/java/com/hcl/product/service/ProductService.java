package com.hcl.product.service;

import java.util.List;

import com.hcl.product.dto.ProductDto;

/***
 * 
 * @author Anuradha
 *
 */

public interface ProductService {
	
	List<ProductDto> products(Integer categoryId);

}
