package com.hcl.product.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class ProductDetailsDto implements Serializable{
	
	private static final long serialVersionUID = 8052229872485261335L;
	
	private String productDesc;
	private Double productCharge;

}
