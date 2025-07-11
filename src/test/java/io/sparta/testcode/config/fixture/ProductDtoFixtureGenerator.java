package io.sparta.testcode.config.fixture;

import io.sparta.testcode.product.controller.dto.ProductCreateRequest;

public class ProductDtoFixtureGenerator {
	public static final String PRODUCT_NAME = "Product Name";
	public static final int PRODUCT_STOCK = 100;

	public static ProductCreateRequest generateProductCreateRequest() {
		return new ProductCreateRequest(PRODUCT_NAME, PRODUCT_STOCK);
	}
}
