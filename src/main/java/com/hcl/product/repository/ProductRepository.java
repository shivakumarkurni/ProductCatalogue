package com.hcl.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.product.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	List<Product> findByProductNameAndCategoryId(String productName, Integer categoryId);
	List<Product> findByCategoryId(Integer categoryId);

	Product findByProductId(Integer productId);

}
