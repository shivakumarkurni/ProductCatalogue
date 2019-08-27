package com.hcl.product.controller;

import static org.junit.Assert.fail;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.hcl.product.service.ProductAnalysisServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class ProductAnalysisControllerTest {

	@Mock
	ProductAnalysisServiceImpl productAnalysisServiceImpl;

	@InjectMocks
	ProductAnalysisController productAnalysisController;

	MockMvc mockMvc;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.standaloneSetup(productAnalysisController).build();

	}

	@Test
	public void testGetAnalysisReport() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/analysis/BUYED")
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.ALL)).andExpect(status().isOk());
	}

}
