package com.hcl.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.hcl.product.dto.FileStorageProperties;

@SpringBootApplication
@EnableConfigurationProperties({
    FileStorageProperties.class
})
public class ProductCataLogueApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductCataLogueApplication.class, args);
	}

}
