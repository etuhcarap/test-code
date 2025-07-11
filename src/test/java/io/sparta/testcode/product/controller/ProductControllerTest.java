package io.sparta.testcode.product.controller;

import static org.springframework.http.HttpHeaders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.sparta.testcode.config.fixture.ProductDtoFixtureGenerator;
import io.sparta.testcode.product.controller.dto.ProductCreateRequest;
import io.sparta.testcode.product.service.ProductService;

@DisplayName("Controller:Product")
@WebMvcTest(controllers = ProductController.class)
@AutoConfigureMockMvc
class ProductControllerTest {
	@MockitoBean
	private ProductService productService;

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	@DisplayName("[201:CREATED]상품 생성 API")
	void createProduct() throws Exception {
		// Given
		String endpoint = "/api/products";
		ProductCreateRequest productCreateRequest =
			ProductDtoFixtureGenerator.generateProductCreateRequest();

		// When
		ResultActions resultActions = mockMvc.perform(post(endpoint)
			.contentType(MediaType.APPLICATION_JSON)
			.content(objectMapper.writeValueAsString(productCreateRequest))
		);

		// Then
		resultActions
			.andExpect(status().isCreated())
			.andExpect(header().exists(LOCATION))
			.andDo(print())
		;
	}

}
