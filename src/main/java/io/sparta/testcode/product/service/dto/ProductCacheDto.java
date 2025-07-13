package io.sparta.testcode.product.service.dto;

import java.time.LocalDateTime;

import lombok.Getter;

@Getter
public class ProductCacheDto {
	private Long id;
	private String name;
	private int stock;
	private LocalDateTime createdAt;

	public ProductCacheDto(Long id, String name, int stock, LocalDateTime createdAt) {
		this.id = id;
		this.name = name;
		this.stock = stock;
		this.createdAt = createdAt;
	}
}
