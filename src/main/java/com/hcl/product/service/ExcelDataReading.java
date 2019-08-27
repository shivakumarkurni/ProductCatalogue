package com.hcl.product.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.hcl.product.dto.ResponseDto;

public interface ExcelDataReading {
	
	public ResponseDto excelDataStoreToDatabase(MultipartFile reapExcelDataFile) throws IOException;

}
