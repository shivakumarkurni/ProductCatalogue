package com.hcl.product.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.hcl.product.dto.FileUploadExcelDto;
import com.hcl.product.dto.ResponseDto;
import com.hcl.product.entity.Category;
import com.hcl.product.entity.Product;
import com.hcl.product.repository.CategoryRepository;
import com.hcl.product.repository.ProductRepository;

@Service
public class ExcelDataReadingImpl implements ExcelDataReading {

	@Autowired
	CategoryRepository categoryRepository;
	@Autowired
	ProductRepository productRepository;
	
	@Autowired ExcelDataReading excelDataReading;


	@Override
	public ResponseDto excelDataStoreToDatabase(MultipartFile reapExcelDataFile) throws IOException {

		
		List<FileUploadExcelDto> tempStudentList = new ArrayList<>();

		XSSFWorkbook workbook = new XSSFWorkbook(reapExcelDataFile.getInputStream());
		XSSFSheet worksheet = workbook.getSheetAt(0);

		for (int i = 1; i < worksheet.getPhysicalNumberOfRows(); i++) {
			FileUploadExcelDto fileUploadExcelDto = new FileUploadExcelDto();

			XSSFRow row = worksheet.getRow(i);

			fileUploadExcelDto.setCateloge((row.getCell(0)).toString());
			fileUploadExcelDto.setProduct((row.getCell(1)).toString());
			fileUploadExcelDto.setDiscription(row.getCell(2).toString());
			fileUploadExcelDto.setCharge((row.getCell(3)).getNumericCellValue());
			tempStudentList.add(fileUploadExcelDto);
		}

		
		return excelDataReading.excelDataStoreToDatabase2(tempStudentList);

	}
	
	
	@Override
	public ResponseDto excelDataStoreToDatabase2(List<FileUploadExcelDto> tempStudentList)  {
		// data updation to database

		
				for (FileUploadExcelDto fileupload : tempStudentList) {

					List<Category> categorys = categoryRepository.findByCategoryName(fileupload.getCateloge().trim().toUpperCase());

					Product product;

					if (categorys.isEmpty()) {
						product = new Product();
						Category category = new Category();
						category.setCategoryName(fileupload.getCateloge().trim().toUpperCase());

						categoryRepository.save(category);
						

						product.setCategoryId(category.getCategoryId());

					} else {
						product = new Product();
						
						List<Product> products = productRepository.findByProductNameAndCategoryId(fileupload.getProduct(), categorys.get(0).getCategoryId());
						product.setCategoryId(categorys.get(0).getCategoryId());

						if(!products.isEmpty()) 
							product.setProductId(products.get(0).getProductId());


					}

					fileupload.getCharge();
					product.setProductCharge(fileupload.getCharge());
					product.setProductDesc(fileupload.getDiscription());
					product.setProductName(fileupload.getProduct());

					productRepository.save(product);
 
				}

				ResponseDto responseDto = new ResponseDto();
				responseDto.setMessage("succsessfully uploaded");
				responseDto.setStatusCode(HttpStatus.CREATED.value());
				return responseDto;

		
	}
	
	
	

}
