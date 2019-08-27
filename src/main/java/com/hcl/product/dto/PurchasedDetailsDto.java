package com.hcl.product.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class PurchasedDetailsDto implements Serializable{

	private static final long serialVersionUID = 8228426933543575497L;
	
	private Integer statusCode;
	private String message;

}
