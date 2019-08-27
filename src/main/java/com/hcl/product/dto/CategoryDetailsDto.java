package com.hcl.product.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class CategoryDetailsDto implements Serializable{

	private static final long serialVersionUID = -6566203865949694322L;
	
	private Integer categoryId;
	private String categoryName;

}
