package com.ecommerce.toyshop.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ecommerce.toyshop.entities.Discount;

@Repository
public interface DiscountRepository extends JpaRepository<Discount,Long> {
	
	@Query(value="SELECT * FROM discounts WHERE product_id = :percent ",nativeQuery=true)
	Optional<Discount> discountByProductId(@Param("percent")long productId);
}
