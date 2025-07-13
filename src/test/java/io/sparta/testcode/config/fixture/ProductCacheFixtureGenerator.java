package io.sparta.testcode.config.fixture;

import java.time.LocalDateTime;

import io.sparta.testcode.product.service.dto.ProductCacheDto;

public class ProductCacheFixtureGenerator {

	public static final Long PRODUCT_ID = 1L;
	public static final String PRODUCT_NAME = "Product Name";
	public static final int PRODUCT_STOCK = 100;
	public static final LocalDateTime PRODUCT_CREATED_AT = LocalDateTime.now();

	public static ProductCacheDto generateMock() {
		return new ProductCacheDto(PRODUCT_ID, PRODUCT_NAME, PRODUCT_STOCK, PRODUCT_CREATED_AT);
	}
}
