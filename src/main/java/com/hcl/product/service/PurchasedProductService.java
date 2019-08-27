package com.hcl.product.service;

import com.hcl.product.dto.PurchasedProductDto;
import com.hcl.product.dto.PurchasedDetailsDto;

public interface PurchasedProductService {
	public PurchasedDetailsDto buyProduct(PurchasedProductDto buyProductDto);
}
