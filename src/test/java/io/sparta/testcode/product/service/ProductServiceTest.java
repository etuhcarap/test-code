package io.sparta.testcode.product.service;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import io.sparta.testcode.config.fixture.ProductDtoFixtureGenerator;
import io.sparta.testcode.product.controller.dto.ProductCreateRequest;
import io.sparta.testcode.product.domain.model.Product;
import io.sparta.testcode.product.domain.repository.ProductRepository;

/**
 * 서비스 계층
 * - 비지니스 로직 처리에 필요한
 * - 여러 의존성들을 하나의 트랜잭션으로 묶는 계층
 */
@DisplayName("Service:Product")
@ExtendWith(MockitoExtension.class)
class ProductServiceTest {
	@Mock
	private ProductRepository productRepository;

	@InjectMocks
	private ProductService productService;

	@Test
	@DisplayName("상품 생성")
	void create() {
		// Given
		ProductCreateRequest productCreateRequest = ProductDtoFixtureGenerator.generateProductCreateRequest();
		when(productRepository.save(any(Product.class)))
			.thenReturn(any(Product.class));

		// When
		productService.createProduct(productCreateRequest);

		// Then
		verify(productRepository, times(1))
			.save(any(Product.class));
	}

}
