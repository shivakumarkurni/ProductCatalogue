package com.hcl.product.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductAnalysisDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer productId;
	private String productName;
	private Long count;

}
