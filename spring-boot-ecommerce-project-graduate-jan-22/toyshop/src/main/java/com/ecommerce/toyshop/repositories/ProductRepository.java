package com.ecommerce.toyshop.repositories;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.ecommerce.toyshop.entities.Product;

public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {
	
	@Query(value ="SELECT DISTINCT * "
			+ "FROM products "
			+ "INNER JOIN product_tags on (product_tags.product_id = products.id) "
			+ "INNER JOIN tags on (product_tags.tag_id = tags.id) "
			+ "WHERE tags.name = :tag AND products.discontinued =false", nativeQuery = true)
	Iterable<Product> findAllByTag(@Param("tag") String tag);

}
