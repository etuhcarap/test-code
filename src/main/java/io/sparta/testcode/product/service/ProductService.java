package io.sparta.testcode.product.service;

import org.springframework.stereotype.Service;

import io.sparta.testcode.product.controller.dto.ProductCreateRequest;
import io.sparta.testcode.product.domain.model.Product;
import io.sparta.testcode.product.domain.repository.ProductRepository;

@Service
public class ProductService {
	private final ProductRepository productRepository;

	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	// 상품 테이블에 상품 정보를 저장
	public void createProduct(ProductCreateRequest productCreateRequest) {
		Product product = Product.of(
			productCreateRequest.getName(),
			productCreateRequest.getStock()
		);

		productRepository.save(product);
	}
}
