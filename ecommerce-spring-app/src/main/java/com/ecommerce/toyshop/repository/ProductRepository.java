package com.ecommerce.toyshop.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ecommerce.toyshop.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	
	// query by JPA: SELECT * FROM Product WHERE name = ?1;
	public Product findByName(String name);
	
	@Query(value ="SELECT DISTINCT * "
			+ "FROM products "
			+ "INNER JOIN product_tags on (product_tags.product_id = products.id) "
			+ "INNER JOIN tags on (product_tags.tag_id = tags.id) "
			+ "WHERE tags.name = :tag AND products.discontinued =false", nativeQuery = true)
	Iterable<Product> findAllByTag(@Param("tag") String tag);
	
	
	@Query(value="SELECT * "
			+ " FROM products"
			+ " WHERE discontinued = false",
			countQuery = "SELECT count(*) FROM products",
			nativeQuery = true)
	Page<Product> findAllNotDiscontinued(Pageable pageable);
	
};