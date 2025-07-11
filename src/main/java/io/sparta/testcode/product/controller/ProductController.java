package io.sparta.testcode.product.controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import io.sparta.testcode.product.controller.dto.ProductCreateRequest;
import io.sparta.testcode.product.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	private final ProductService productService;

	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	/**
	 * POST http://localhost:8080/api/products
	 * Contents-Type: application/json
	 *
	 * {
	 * 		"name" : "상품명",
	 * 		"stock" : 100
	 * }
	 */
	@PostMapping
	ResponseEntity<Void> createProduct(
		@RequestBody ProductCreateRequest productCreateRequest
	) {
		productService.createProduct(productCreateRequest);

		URI createdProductUri = UriComponentsBuilder.fromUriString("/api/products/{productId}")
			.build(1L);
		return ResponseEntity.created(createdProductUri).build();
	}
}
