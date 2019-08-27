package com.hcl.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.product.entity.PurchasedProduct;

@Repository
public interface PurchasedProductRepository extends JpaRepository<PurchasedProduct, Integer> {

}
