package com.hcl.product.dto;

import lombok.Getter;
import lombok.Setter;

/***
 * 
 * @author Anuradha
 *
 */
@Setter
@Getter
public class ProductDto {
	
	private Integer productId;
	private Double productCharge;
	private String productName;
	private String productDesc;

}
