package com.hcl.product.service;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.product.dto.ProductAnalysisDTO;
import com.hcl.product.exception.BankProductException;
import com.hcl.product.repository.PurchasedProductRepository;

/**
 * @author Shiva
 * 
 * This class will return records based on day wise,weekly,monthly
 * 
 *
 */
@Service
public class ProductAnalysisServiceImpl implements ProductAnalysisService {

	private static final Logger logger = LoggerFactory.getLogger(ProductAnalysisServiceImpl.class);

	@Autowired
	PurchasedProductRepository purchasedProductRepository;

	/**
	 * @param data type string
	 * 
	 * This method returns list of ProductAnalysisDTO objects
	 * 
	 * @return ProductAnalysisDTO contains productId,productName,count of products
	 * 
	 *
	 */

	public List<ProductAnalysisDTO> analysisReport(String data) {

		logger.info("Inside Analysis Service Impl data:{}", data);

		LocalDate todaysDate = LocalDate.now();
		List<ProductAnalysisDTO> purchasedAnalysisDTOList = null;
		String status = "BUYED";

		switch (data) {

		case "day":
			logger.info("Inside day block todaysDate:{}, status:{}", todaysDate, status);
			purchasedAnalysisDTOList = purchasedProductRepository.getByPurchasedDate(todaysDate, status);
			break;
		case "week":
			LocalDate toDate = todaysDate.minusDays(7);
			logger.info("Inside week block toDate:{}, todaysDate:{}, status:{}", toDate, todaysDate, status);
			purchasedAnalysisDTOList = purchasedProductRepository.getByStatus(toDate, todaysDate, status);
			break;
		case "monthly":
			LocalDate yearDate = todaysDate.minusDays(30);

			logger.info("Inside monthly block yearDate:{}, todaysDate:{}, status:{}", yearDate, todaysDate, status);

			purchasedAnalysisDTOList = purchasedProductRepository.getByStatus(yearDate, todaysDate, status);
			break;
		default:
			throw new BankProductException("No Records Found");
		}
		return purchasedAnalysisDTOList;
	}

}
