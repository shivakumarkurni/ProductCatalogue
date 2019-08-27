package com.hcl.product.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.hcl.product.dto.FileUploadExcelDto;
import com.hcl.product.dto.ResponseDto;

public interface ExcelDataReading {
	
	public ResponseDto excelDataStoreToDatabase(MultipartFile reapExcelDataFile) throws IOException;
	public ResponseDto excelDataStoreToDatabase2(List<FileUploadExcelDto> tempStudentList)  ;

}
