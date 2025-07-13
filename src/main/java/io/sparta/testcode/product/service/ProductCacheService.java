package io.sparta.testcode.product.service;

import org.springframework.stereotype.Service;

import io.sparta.testcode.product.domain.model.Product;
import io.sparta.testcode.product.domain.repository.ProductRepository;
import io.sparta.testcode.product.service.dto.ProductCacheDto;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductCacheService {
	private final ProductRepository productRepository;
	private final ProductRedisService productRedisService;

	public void setProductCache(Long id) {
		Product product = productRepository.findById(id).orElseThrow();
		ProductCacheDto productCacheDto = new ProductCacheDto(
			product.getId(),
			product.getName(),
			product.getStock(),
			product.getCreatedAt()
		);

		productRedisService.setProduct(productCacheDto);
	}

	public ProductCacheDto getProductCache(Long id) {
		return productRedisService.getProduct(id);
	}
}
