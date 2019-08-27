package com.hcl.product.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hcl.product.dto.ProductAnalysisDTO;

@Service
public interface ProductAnalysisService {

	public List<ProductAnalysisDTO> analysisReport(String data);
}
