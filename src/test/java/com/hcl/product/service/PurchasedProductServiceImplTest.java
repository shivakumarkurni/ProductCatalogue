package com.hcl.product.service;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.product.dto.PurchasedDetailsDto;
import com.hcl.product.dto.PurchasedProductDto;
import com.hcl.product.entity.PurchasedProduct;
import com.hcl.product.repository.PurchasedProductRepository;

@RunWith(MockitoJUnitRunner.class)
public class PurchasedProductServiceImplTest {

	@Mock
	PurchasedProductRepository purchasedProductRepository;

	@InjectMocks
	PurchasedProductServiceImpl purchasedProductServiceImpl;

	@Test
	public void testBuyProduct() {

		PurchasedDetailsDto purchasedDetailsDto = new PurchasedDetailsDto();
		purchasedDetailsDto.setMessage("Product Purchased Success...");
		purchasedDetailsDto.setStatusCode(200);
		PurchasedProduct purchasedProduct = new PurchasedProduct();

		purchasedProduct.setProductId(1);
		purchasedProduct.setName("HCL");
		purchasedProduct.setPurchasedDate(LocalDate.now());
		purchasedProduct.setPurchasedProductId(1);
		purchasedProduct.setStatus("BUYED");
		purchasedProduct.setAnnualIncome(100000D);
		purchasedProduct.setDob(LocalDate.now());
		purchasedProduct.setEmail("abc@gmail.com");
		purchasedProduct.setGender("male");
		purchasedProduct.setMobileNo(9030853226L);
		purchasedProduct.setName("abc");

		PurchasedProductDto purchasedProductDto = new PurchasedProductDto();
		purchasedProductDto.setName("abc");
		purchasedProductDto.setProductId(1);
		purchasedProductDto.setAnnualIncome(100000D);
		purchasedProductDto.setEmail("abc@gmail.com");
		purchasedProductDto.setDob(LocalDate.now());
		purchasedProductDto.setGender("male");
		purchasedProductDto.setMobileNo(9030853228L);

		List<PurchasedProduct> purchasedProducts = new ArrayList<>();
		purchasedProducts.add(purchasedProduct);

		PurchasedDetailsDto actualValue = purchasedProductServiceImpl.buyProduct(purchasedProductDto);

		assertEquals(purchasedDetailsDto.getMessage(), actualValue.getMessage());

	}

	@Test
	public void testBuyProductEmail() {

		PurchasedDetailsDto purchasedDetailsDto = new PurchasedDetailsDto();
		purchasedDetailsDto.setMessage("Product Purchased Success...");
		purchasedDetailsDto.setStatusCode(406);
		PurchasedProduct purchasedProduct = new PurchasedProduct();

		purchasedProduct.setProductId(1);
		purchasedProduct.setName("HCL");
		purchasedProduct.setPurchasedDate(LocalDate.now());
		purchasedProduct.setPurchasedProductId(1);
		purchasedProduct.setStatus("BUYED");
		purchasedProduct.setAnnualIncome(100000D);
		purchasedProduct.setDob(LocalDate.now());
		purchasedProduct.setEmail("abc@gmail.com");
		purchasedProduct.setGender("male");
		purchasedProduct.setMobileNo(9030853226L);
		purchasedProduct.setName("abc");

		PurchasedProductDto purchasedProductDto = new PurchasedProductDto();
		purchasedProductDto.setName("abc");
		purchasedProductDto.setProductId(1);
		purchasedProductDto.setAnnualIncome(100000D);
		purchasedProductDto.setEmail("abcgmail.com");
		purchasedProductDto.setDob(LocalDate.now());
		purchasedProductDto.setGender("male");
		purchasedProductDto.setMobileNo(9030853228L);

		List<PurchasedProduct> purchasedProducts = new ArrayList<>();
		purchasedProducts.add(purchasedProduct);

		PurchasedDetailsDto actualValue = purchasedProductServiceImpl.buyProduct(purchasedProductDto);

		assertEquals(purchasedDetailsDto.getStatusCode(), actualValue.getStatusCode());

	}

	@Test
	public void testBuyProductMobile() {

		PurchasedDetailsDto purchasedDetailsDto = new PurchasedDetailsDto();
		purchasedDetailsDto.setMessage("Product Purchased Success...");
		purchasedDetailsDto.setStatusCode(406);
		PurchasedProduct purchasedProduct = new PurchasedProduct();

		purchasedProduct.setProductId(1);
		purchasedProduct.setName("HCL");
		purchasedProduct.setPurchasedDate(LocalDate.now());
		purchasedProduct.setPurchasedProductId(1);
		purchasedProduct.setStatus("BUYED");
		purchasedProduct.setAnnualIncome(100000D);
		purchasedProduct.setDob(LocalDate.now());
		purchasedProduct.setEmail("abc@gmail.com");
		purchasedProduct.setGender("male");
		purchasedProduct.setMobileNo(9030853226L);
		purchasedProduct.setName("abc");

		PurchasedProductDto purchasedProductDto = new PurchasedProductDto();
		purchasedProductDto.setName("abc");
		purchasedProductDto.setProductId(1);
		purchasedProductDto.setAnnualIncome(100000D);
		purchasedProductDto.setEmail("abcgmail.com");
		purchasedProductDto.setDob(LocalDate.now());
		purchasedProductDto.setGender("male");
		purchasedProductDto.setMobileNo(903085L);

		List<PurchasedProduct> purchasedProducts = new ArrayList<>();
		purchasedProducts.add(purchasedProduct);

		PurchasedDetailsDto actualValue = purchasedProductServiceImpl.buyProduct(purchasedProductDto);

		assertEquals(purchasedDetailsDto.getStatusCode(), actualValue.getStatusCode());

	}

}
