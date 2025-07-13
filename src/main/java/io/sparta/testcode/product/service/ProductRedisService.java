package io.sparta.testcode.product.service;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.sparta.testcode.product.service.dto.ProductCacheDto;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductRedisService {
	private final RedisTemplate<String, String> redisTemplate;
	private final ObjectMapper objectMapper;
	private static final String PRODUCT_KEY_TEMPLATE = "product:%s";

	public void setProduct(ProductCacheDto productCacheDto) {
		try {
			String productKey = getProductKey(productCacheDto.getId());
			String productJson = objectMapper.writeValueAsString(productCacheDto);
			redisTemplate.opsForValue().set(productKey, productJson);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
	}

	public ProductCacheDto getProduct(Long id) {
		try {
			String productKey = getProductKey(id);
			String productJson = redisTemplate.opsForValue().get(productKey);
			return objectMapper.readValue(productJson, ProductCacheDto.class);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
	}

	private String getProductKey(Long id) {
		return PRODUCT_KEY_TEMPLATE.formatted(id);
	}
}
