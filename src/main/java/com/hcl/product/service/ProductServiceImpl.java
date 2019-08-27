package com.hcl.product.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.product.dto.ProductDto;
import com.hcl.product.entity.Product;
import com.hcl.product.repository.CategoryRepository;
import com.hcl.product.repository.ProductRepository;

/***
 * 
 * @author Anuradha
 *
 */
@Service
public class ProductServiceImpl implements ProductService {

	private static Logger LOGGER = LoggerFactory.getLogger(ProductServiceImpl.class);

	@Autowired
	ProductRepository productRepository;

	@Autowired
	CategoryRepository categoryRepository;

	@Override
	public List<ProductDto> products(Integer categoryId) {
		LOGGER.info("ProductServiceImpl :: categoryId ", categoryId);

		List<ProductDto> productList = new ArrayList<>();

		List<Product> products = productRepository.findByCategoryId(categoryId);

		for (Product product : products) {
			ProductDto productDto = new ProductDto();
			BeanUtils.copyProperties(product, productDto);
			productList.add(productDto);
		}

		return productList;
	}
}
