package com.hcl.product.controller;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.hcl.product.dto.ResponseDto;
import com.hcl.product.service.ExcelDataReading;
import com.hcl.product.service.FileStorageService;

@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
@RestController
public class FileController {

    private static final Logger logger = LoggerFactory.getLogger(FileController.class);
    
   
    @Autowired
    private FileStorageService fileStorageService;
    
    @Autowired
    ExcelDataReading excelDataReading;
	
    
    @PostMapping("/products")
    public ResponseEntity<ResponseDto> mapReapExcelDatatoDB(@RequestParam("file") MultipartFile reapExcelDataFile) throws IOException {
    	logger.info("FileController --> mapReapExcelDatatoDB ");
    	
    	
        fileStorageService.storeFile(reapExcelDataFile);
     return ResponseEntity.status(HttpStatus.CREATED).body(excelDataReading.excelDataStoreToDatabase(reapExcelDataFile));

        
        
    }
}