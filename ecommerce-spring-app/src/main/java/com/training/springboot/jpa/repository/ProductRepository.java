package com.training.springboot.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.training.springboot.jpa.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	
	// query by JPA: SELECT * FROM Product WHERE name = ?1;
	public Product findByName(String name);
	
}