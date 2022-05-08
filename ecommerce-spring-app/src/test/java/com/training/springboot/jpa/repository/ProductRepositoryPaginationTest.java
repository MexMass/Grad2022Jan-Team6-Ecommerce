package com.training.springboot.jpa.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.ecommerce.toyshop.entities.Product;
import com.ecommerce.toyshop.repository.ProductRepository;

@SpringBootTest
public class ProductRepositoryPaginationTest {

	@Autowired
	private ProductRepository productRepository;

	@Test
	public void testProductPagination() {
		int pageNo = 0;
		int pageSize = 2;

		// create pageable object
		Pageable pageable = PageRequest.of(pageNo, pageSize);

		Page<Product> page = productRepository.findAll(pageable);

		List<Product> list = page.getContent();

		for (Product product : list) {
			System.out.println(product);
		}

	}
}
