package io.sparta.testcode.product.service;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import io.sparta.testcode.config.fixture.ProductCacheFixtureGenerator;
import io.sparta.testcode.config.redis.RedisTestContainersExtension;
import io.sparta.testcode.product.service.dto.ProductCacheDto;

@SpringBootTest
@ExtendWith(RedisTestContainersExtension.class)
@ActiveProfiles("test")
public class ProductRedisServiceTest {
	@Autowired
	private ProductRedisService productRedisService;

	@Test
	@DisplayName("상품 캐시 저장")
	void setProduct() {
		// Given
		ProductCacheDto productCacheDto = ProductCacheFixtureGenerator.generateMock();

		// When
		productRedisService.setProduct(productCacheDto);

		// Then
		ProductCacheDto product = productRedisService.getProduct(productCacheDto.getId());
		assertThat(product).isNotNull();
	}
}
