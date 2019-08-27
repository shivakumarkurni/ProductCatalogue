package com.hcl.product.dto;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class PurchasedProductDto implements Serializable{

	private static final long serialVersionUID = 5600262257403999134L;
	
	private Integer productId;
	private String name;
	private LocalDate dob;
	private String email;
	private Long mobileNo;
	private Double annualIncome;
	private String gender;
}
