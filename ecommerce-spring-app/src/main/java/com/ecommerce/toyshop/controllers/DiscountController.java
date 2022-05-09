package com.ecommerce.toyshop.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.toyshop.entities.Discount;
import com.ecommerce.toyshop.entities.Product;
import com.ecommerce.toyshop.services.DiscountService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class DiscountController {
	
	private DiscountService discountService;
	
	public DiscountController(@Autowired DiscountService service) {
		this.discountService = service;
	}
	
	@GetMapping(value = "/discount/id/{id}", produces = "application/json")
	public Optional<Discount> getDiscount(@PathVariable("id") Long id) {
		Optional<Discount> percent = discountService.getDiscount(id);
		return percent;
	}
}
