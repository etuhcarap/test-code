package io.sparta.testcode.product.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.sparta.testcode.product.service.ProductCacheService;
import io.sparta.testcode.product.service.dto.ProductCacheDto;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/products/cache")
@RequiredArgsConstructor
public class ProductCacheController {
	private final ProductCacheService productCacheService;

	@PostMapping("{id}")
	ResponseEntity<Void> setProductCache(@PathVariable("id") Long id) {
		productCacheService.setProductCache(id);
		return ResponseEntity.accepted().build();
	}

	@GetMapping("{id}")
	ResponseEntity<ProductCacheDto> getProductCache(@PathVariable("id") Long id) {
		ProductCacheDto productCache = productCacheService.getProductCache(id);
		return ResponseEntity.ok(productCache);
	}
}
