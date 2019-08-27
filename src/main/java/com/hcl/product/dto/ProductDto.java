package com.hcl.product.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

/***
 * 
 * @author Anuradha
 *
 */
@Setter
@Getter
public class ProductDto implements Serializable {

	private static final long serialVersionUID = -6566203865949694322L;

	private Integer productId;
	private String productName;

}
