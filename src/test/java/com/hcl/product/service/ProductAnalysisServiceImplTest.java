package com.hcl.product.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.product.dto.ProductAnalysisDTO;
import com.hcl.product.exception.BankProductException;
import com.hcl.product.repository.PurchasedProductRepository;

@RunWith(MockitoJUnitRunner.class)
public class ProductAnalysisServiceImplTest {

	@Mock
	PurchasedProductRepository purchasedProductRepository;

	@InjectMocks
	ProductAnalysisServiceImpl productAnalysisServiceImpl;

	@Test
	public void testAnalysisReport() {

		List<ProductAnalysisDTO> purchasedAnalysisDTOList = new ArrayList<>();

		ProductAnalysisDTO productAnalysisDTO = new ProductAnalysisDTO();

		productAnalysisDTO.setProductId(1);
		productAnalysisDTO.setProductName("Hcl");
		productAnalysisDTO.setCount(3L);
		purchasedAnalysisDTOList.add(productAnalysisDTO);

		ProductAnalysisDTO productAnalysisDTO1 = new ProductAnalysisDTO();

		productAnalysisDTO1.setProductId(1);
		productAnalysisDTO1.setProductName("Hcl");
		productAnalysisDTO1.setCount(3L);
		purchasedAnalysisDTOList.add(productAnalysisDTO1);

		Mockito.when(purchasedProductRepository.getByPurchasedDate(Mockito.any(), Mockito.any()))
				.thenReturn(purchasedAnalysisDTOList);

		List<ProductAnalysisDTO> actualValue = productAnalysisServiceImpl.analysisReport("day");
		assertEquals(purchasedAnalysisDTOList.size(), actualValue.size());

	}

	@Test
	public void testAnalysisReportWeekly() {

		List<ProductAnalysisDTO> purchasedAnalysisDTOList = new ArrayList<>();

		ProductAnalysisDTO productAnalysisDTO = new ProductAnalysisDTO();

		productAnalysisDTO.setProductId(1);
		productAnalysisDTO.setProductName("Hcl");
		productAnalysisDTO.setCount(3L);
		purchasedAnalysisDTOList.add(productAnalysisDTO);

		ProductAnalysisDTO productAnalysisDTO1 = new ProductAnalysisDTO();

		productAnalysisDTO1.setProductId(1);
		productAnalysisDTO1.setProductName("Hcl");
		productAnalysisDTO1.setCount(3L);
		purchasedAnalysisDTOList.add(productAnalysisDTO1);

		Mockito.when(purchasedProductRepository.getByStatus(Mockito.any(), Mockito.any(), Mockito.any()))
				.thenReturn(purchasedAnalysisDTOList);

		List<ProductAnalysisDTO> actualValue = productAnalysisServiceImpl.analysisReport("week");
		assertEquals(purchasedAnalysisDTOList.size(), actualValue.size());

	}

	@Test
	public void testAnalysisReportMonthly() {

		List<ProductAnalysisDTO> purchasedAnalysisDTOList = new ArrayList<>();

		ProductAnalysisDTO productAnalysisDTO = new ProductAnalysisDTO();

		productAnalysisDTO.setProductId(1);
		productAnalysisDTO.setProductName("Hcl");
		productAnalysisDTO.setCount(3L);
		purchasedAnalysisDTOList.add(productAnalysisDTO);

		ProductAnalysisDTO productAnalysisDTO1 = new ProductAnalysisDTO();

		productAnalysisDTO1.setProductId(1);
		productAnalysisDTO1.setProductName("Hcl");
		productAnalysisDTO1.setCount(3L);
		purchasedAnalysisDTOList.add(productAnalysisDTO1);

		Mockito.when(purchasedProductRepository.getByStatus(Mockito.any(), Mockito.any(), Mockito.any()))
				.thenReturn(purchasedAnalysisDTOList);

		List<ProductAnalysisDTO> actualValue = productAnalysisServiceImpl.analysisReport("monthly");
		assertEquals(purchasedAnalysisDTOList.size(), actualValue.size());

	}

	@Test(expected = BankProductException.class)
	public void testAnalysisReportException() {

		List<ProductAnalysisDTO> purchasedAnalysisDTOList = new ArrayList<>();

		ProductAnalysisDTO productAnalysisDTO = new ProductAnalysisDTO();

		productAnalysisDTO.setProductId(1);
		productAnalysisDTO.setProductName("Hcl");
		productAnalysisDTO.setCount(3L);
		purchasedAnalysisDTOList.add(productAnalysisDTO);

		ProductAnalysisDTO productAnalysisDTO1 = new ProductAnalysisDTO();

		productAnalysisDTO1.setProductId(1);
		productAnalysisDTO1.setProductName("Hcl");
		productAnalysisDTO1.setCount(3L);
		purchasedAnalysisDTOList.add(productAnalysisDTO1);

		
		 productAnalysisServiceImpl.analysisReport("yearly");

	}

}
