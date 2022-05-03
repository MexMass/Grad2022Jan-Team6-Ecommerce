package com.ecommerce.toyshop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.toyshop.repositories.DiscountRepository;

@Service
public class DiscountService {
	
	@Autowired
	private DiscountRepository repository;
}
