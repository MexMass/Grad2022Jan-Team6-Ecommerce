package com.training.springboot.jpa.services;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.training.springboot.jpa.entities.Product;
import com.training.springboot.jpa.entities.ProductDto;
import com.training.springboot.jpa.entities.Tag;
import com.training.springboot.jpa.repository.ProductRepository;
import com.training.springboot.jpa.repository.TagRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	TagRepository tagRepository;

	public List<Product> getProductBasedOnPage(int pageNo, int pageSize) {

		PageRequest pageable = PageRequest.of(pageNo, pageSize);
		Page<Product> page = productRepository.findAll(pageable);
		int totalPages = page.getTotalPages();
		if (totalPages < pageNo) {
			pageNo = totalPages - 1;
		}
		pageable = PageRequest.of(pageNo, pageSize);
		page = productRepository.findAll(pageable);
		List<Product> products = page.getContent();

		return products;

	}
	
	public List<Product> getAllProducts() {
		List<Product> products = productRepository.findAll();
		return products;
	}
	
	public void addNewProduct(ProductDto productDto) { // receive the DTO (data transfer object)
		
		Product savedProduct = new Product(); // create new object for the to-be saved product
		savedProduct.setName(productDto.getName());
		savedProduct.setSupplier_name(productDto.getSupplier_name());
		savedProduct.setUnits_in_stock(productDto.getUnits_in_stock());
		savedProduct.setTotal_price(productDto.getTotal_price());
		
	    Collection<Tag> tags = new HashSet<>(); // create tags collection for the to-be saved product
	    
	    for (String tag : productDto.getTags()) { // for each tag in the DTO (data transfer object)
			tags.add(tagRepository.findByName(tag)); // search the tag by name and add to the collection
		}
		
		savedProduct.setTags(tags);
		savedProduct.setDiscontinued(productDto.isDiscontinued());
		savedProduct.setImage_url(productDto.getImage_url());
		productRepository.save(savedProduct); // save product
	}
	


}
