package com.hcl.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.product.entity.Category;
import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
	
	List<Category> findByCategoryName(String categoryname);

}
