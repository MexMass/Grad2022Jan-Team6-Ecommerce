package com.ecommerce.toyshop.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.toyshop.entities.Discount;
import com.ecommerce.toyshop.repository.DiscountRepository;

@Service
public class DiscountService {
	
	@Autowired
	private DiscountRepository repo;
	
	public Optional<Discount> getDiscount(Long productId) {
		return repo.discountByProductId(productId);
	}
}
