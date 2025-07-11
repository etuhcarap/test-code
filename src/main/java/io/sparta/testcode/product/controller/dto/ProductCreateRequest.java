package io.sparta.testcode.product.controller.dto;

import lombok.Getter;

@Getter
public class ProductCreateRequest {
	private String name;
	private int stock;

	public ProductCreateRequest(String name, int stock) {
		this.name = name;
		this.stock = stock;
	}
}
