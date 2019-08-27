package com.hcl.product.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class PurchasedProduct {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer purchasedProductId;
	private Integer productId;
	private String name;
	private LocalDate dob;
	private String email;
	private Long mobileNo;
	private Double annualIncome;
	private LocalDate purchasedDate;
	private String gender;
	private String status;

}
