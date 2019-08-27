package com.hcl.product.service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.product.dto.PurchasedDetailsDto;
import com.hcl.product.dto.PurchasedProductDto;
import com.hcl.product.entity.PurchasedProduct;
import com.hcl.product.repository.PurchasedProductRepository;

@Service
public class PurchasedProductServiceImpl implements PurchasedProductService {

	private static final Logger LOGGER = LoggerFactory.getLogger(PurchasedProductServiceImpl.class);

	@Autowired
	PurchasedProductRepository purchasedProductRepository;

	public PurchasedDetailsDto buyProduct(PurchasedProductDto purchasedProductDto) {
		LOGGER.debug("PurchasedProductServiceImpl buyProduct()");
		PurchasedDetailsDto purchasedDetailsDto = new PurchasedDetailsDto();
		PurchasedProduct purchasedProduct = new PurchasedProduct();
		List<PurchasedProduct> purcList = purchasedProductRepository
				.findByMobileNoAndProductId(purchasedProductDto.getMobileNo(), purchasedProductDto.getProductId());

		if (validPhoneNumber(purchasedProductDto.getMobileNo())) {
			if (emailValidation(purchasedProductDto.getEmail())) {
				if (!purcList.isEmpty()) {
					purchasedDetailsDto.setStatusCode(302);
					purchasedDetailsDto.setMessage("Your Mobile No Already Registered with this Product..");
				} else {

					BeanUtils.copyProperties(purchasedProductDto, purchasedProduct);
					purchasedProduct.setPurchasedDate(LocalDate.now(ZoneId.systemDefault()));
					purchasedProduct.setStatus("BUYED");
					purchasedProductRepository.save(purchasedProduct);
					purchasedDetailsDto.setStatusCode(201);
					purchasedDetailsDto.setMessage("Product Purchased Success...");
				}
			} else {
				purchasedDetailsDto.setStatusCode(406);
				purchasedDetailsDto.setMessage("Enter Valid Format Email..");
			}
		} else

		{
			purchasedDetailsDto.setStatusCode(406);
			purchasedDetailsDto.setMessage("Enter Valid Mobile No..");
		}

		return purchasedDetailsDto;
	}

	static boolean validPhoneNumber(Long number) {
		String num = number.toString();
		Pattern p = Pattern.compile("^[0-9]{10}$");
		Matcher m = p.matcher(num);
		return (m.find() && m.group().equals(num));
	}

	static boolean emailValidation(String email) {
		String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		return email.matches(regex);
	}

}
