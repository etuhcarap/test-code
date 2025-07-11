package io.sparta.testcode.product.domain.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import io.sparta.testcode.config.fixture.ProductFixtureGenerator;

@DisplayName("Domain:Product")
public class ProductTest {

	@Test
	@DisplayName("상품 도메인 모델 생성")
	void create() {
		// When
		Product product = ProductFixtureGenerator.generateMock();

		// Then
		Assertions.assertThat(product).isNotNull();
	}
}
