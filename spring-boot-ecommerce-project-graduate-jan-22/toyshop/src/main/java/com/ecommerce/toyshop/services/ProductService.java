package com.ecommerce.toyshop.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.toyshop.entities.Product;
import com.ecommerce.toyshop.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	
	//returns all products
	public Iterable<Product> findAll() {
		return repository.findAll();
	}
	
	//find product by id
	public Optional<Product> findById(Long id) {
		return repository.findById(id);
	}
	
	//find all product of a specific tag
	public Iterable<Product> findAllByTag(String tag){
		return repository.findAllByTag(tag);
	}
}
