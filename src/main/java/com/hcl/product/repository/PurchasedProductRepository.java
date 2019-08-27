package com.hcl.product.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hcl.product.dto.ProductAnalysisDTO;
import com.hcl.product.entity.PurchasedProduct;

@Repository
public interface PurchasedProductRepository extends JpaRepository<PurchasedProduct, Integer> {

	@Query("SELECT NEW com.hcl.product.dto.ProductAnalysisDTO(pp.productId,p.productName,count(pp.productId)) FROM PurchasedProduct pp,Product p where pp.productId=p.productId AND pp.purchasedDate=:purchasedDate AND pp.status=:status Group By pp.productId")
	public List<ProductAnalysisDTO> getByPurchasedDate(@Param("purchasedDate") LocalDate purchasedDate,
			@Param("status") String status);

	@Query("SELECT NEW com.hcl.product.dto.ProductAnalysisDTO(pp.productId,p.productName,count(pp.productId)) FROM PurchasedProduct pp,Product p where pp.productId=p.productId AND pp.purchasedDate Between :fromDate AND :toDate AND pp.status=:status Group By pp.productId")
	public List<ProductAnalysisDTO> getByStatus(@Param("fromDate") LocalDate fromDate,
			@Param("toDate") LocalDate toDate,@Param("status") String status);

}
