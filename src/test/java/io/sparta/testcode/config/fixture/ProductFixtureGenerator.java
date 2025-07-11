package io.sparta.testcode.config.fixture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestComponent;

import io.sparta.testcode.product.domain.model.Product;
import io.sparta.testcode.product.domain.repository.ProductRepository;

@TestComponent
public class ProductFixtureGenerator {

	@Autowired
	private ProductRepository productRepository;

	public static final String PRODUCT_NAME = "Product Name";
	public static final int PRODUCT_STOCK = 100;

	public static Product generateMock() {
		return Product.of(PRODUCT_NAME, PRODUCT_STOCK);
	}

	public Product savedProduct() {
		return productRepository.save(generateMock());
	}
}
