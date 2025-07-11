package io.sparta.testcode.product.domain.model;

import io.sparta.testcode.global.jpa.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
public class Product extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private int stock;
	private boolean deleted;

	private Product(String name, int stock) {
		this.name = name;
		this.stock = stock;
	}

	public static Product of(String name, int stock) {
		return new Product(name, stock);
	}

	public void updateProductName(String updateProductName) {
		this.name = updateProductName;
	}

	public void delete() {
		this.deleted = true;
	}
}
