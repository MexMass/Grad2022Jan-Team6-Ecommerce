package com.ecommerce.toyshop.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ecommerce.toyshop.entities.Discount;

public interface DiscountRepository extends JpaRepository {
	
	@Query(value="SELECT percent FROM discounts WHERE product_id = :percent ",nativeQuery=true)
	Optional<Discount> percentByProductId(@Param("percent")Long productId);
}
