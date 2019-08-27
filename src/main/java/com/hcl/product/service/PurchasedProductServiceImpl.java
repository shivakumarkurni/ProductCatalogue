package com.hcl.product.service;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.product.dto.PurchasedProductDto;
import com.hcl.product.entity.PurchasedProduct;
import com.hcl.product.repository.PurchasedProductRepository;
import com.hcl.product.dto.PurchasedDetailsDto;

@Service
public class PurchasedProductServiceImpl implements PurchasedProductService{

	private static final Logger LOGGER = LoggerFactory.getLogger(PurchasedProductServiceImpl.class);

	@Autowired
	PurchasedProductRepository purchasedProductRepository;
	
	public PurchasedDetailsDto buyProduct(PurchasedProductDto purchasedProductDto) {
		LOGGER.debug("PurchasedProductServiceImpl buyProduct()");
		PurchasedProduct purchasedProduct = new PurchasedProduct();
		BeanUtils.copyProperties(purchasedProductDto, purchasedProduct);
		purchasedProduct.setPurchasedDate(LocalDate.now());
		purchasedProductRepository.save(purchasedProduct);
		PurchasedDetailsDto purchasedDetailsDto = new PurchasedDetailsDto();
		purchasedDetailsDto.setStatusCode(201);
		purchasedDetailsDto.setMessage("Product Purchased Success...");
		return purchasedDetailsDto;
	}

}
