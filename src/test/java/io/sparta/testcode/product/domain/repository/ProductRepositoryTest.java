package io.sparta.testcode.product.domain.repository;

import static org.assertj.core.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import io.sparta.testcode.config.fixture.ProductFixtureGenerator;
import io.sparta.testcode.product.domain.model.Product;
import jakarta.persistence.EntityManager;

@Import(ProductFixtureGenerator.class)
@DataJpaTest
@DisplayName("Repository:Product")
class ProductRepositoryTest {
	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private EntityManager entityManager;

	@Autowired
	private ProductFixtureGenerator productFixtureGenerator;

	@Test
	@DisplayName("[insert] 상품 저장")
	void save() {
		// Given
		Product product = ProductFixtureGenerator.generateMock();

		// When
		Product saveProduct = productRepository.save(product);

		// Then
		assertThat(saveProduct.getId()).isNotNull();
		assertThat(saveProduct.getCreatedAt()).isNotNull();
	}

	@Test
	@DisplayName("[update] 상품명 수정")
	void update() {
		// Given
		String updateProductName = "변경된 상품 이름";
		Product savedProduct = productFixtureGenerator.savedProduct();
		entityManager.clear();

		// When
		// id : 1
		// name : Product name
		Product findProduct = productRepository.findById(savedProduct.getId()).orElseThrow();

		// id : 1
		// name : 변경된 상품 이름
		findProduct.updateProductName(updateProductName);
		entityManager.flush();

		// Then
		assertThat(findProduct.getName()).isEqualTo(updateProductName);
	}

	@Test
	@DisplayName("[delete] 상품 삭제")
	void delete() {
		// Given
		Product savedProduct = productFixtureGenerator.savedProduct();
		entityManager.clear();

		// When
		// id : 1
		// name : Product name
		// delete : false
		Product findProduct = productRepository.findById(savedProduct.getId()).orElseThrow();

		// id : 1
		// name : Product name
		// delete : true
		findProduct.delete();
		entityManager.flush();

		// Then
		assertThat(findProduct.isDeleted()).isTrue();
	}

	@Test
	@DisplayName("[예외] 존재하지 않는 상품인 경우")
	void throwException_whenProductIsNotExist() {
		// Given
		Long id = 999L;

		// When & Then
		assertThatExceptionOfType(NoSuchElementException.class)
			.isThrownBy(() -> productRepository.findById(id).orElseThrow());
	}
}
