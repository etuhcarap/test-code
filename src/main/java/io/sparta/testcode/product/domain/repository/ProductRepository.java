package io.sparta.testcode.product.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.sparta.testcode.product.domain.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}

