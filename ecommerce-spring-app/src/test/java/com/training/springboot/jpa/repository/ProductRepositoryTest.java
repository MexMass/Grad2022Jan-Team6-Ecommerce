package com.training.springboot.jpa.repository;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Collection;
import java.util.HashSet;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ecommerce.toyshop.entities.Product;
import com.ecommerce.toyshop.entities.Tag;
import com.ecommerce.toyshop.repository.ProductRepository;
import com.ecommerce.toyshop.repository.TagRepository;

//test the basic CRUD operations
// setup the environment with spring container and 
@SpringBootTest
public class ProductRepositoryTest {

	@Autowired
	ProductRepository repository;
	
	@Autowired
	TagRepository tagRepository;

	@Test
	public void test() {
		assertTrue(true);
	}

	@Test
	public void saveProductObject() {
		// create product
		Product product = new Product();
		product.setName("Test Product Name");
		product.setSupplier_name("Test supplier name");
		product.setUnits_in_stock(100);
		product.setTotal_price(50);
		product.setImage_url("http://www.test_image.com");
		product.setDiscontinued(false);
		
		String tagsS[] = {"age6to12", "videogame"};
		
	    Collection<Tag> tags = new HashSet<>(); // tags collection
	    
	    for (String tag : tagsS) { // for each tag in the tagsS
			tags.add(tagRepository.findByName(tag)); // search the tag by name and add to the collection
		}
		
		product.setTags(tags);
		
		// save product
		Product savedObject = repository.save(product);
				
		// display product info
		System.out.println(savedObject.getId());
		System.out.println(savedObject.toString());
	}
	
	@Test
	public void NullValuesForSaveProductObject() {
		// create product
		Product product = new Product();
		product.setName(null);
		product.setSupplier_name(null);
		product.setTags(null);
		product.setImage_url(null);
		product.setDiscontinued(false);
		
		// save product
		Product savedObject = repository.save(product);
				
		// display product info
		System.out.println(savedObject.getId());
		System.out.println(savedObject.toString());
	}
	
	@Test
	 void updateUsingSaveMethod() {
		
		// find or retrieve an entity by id
		Long id = 1L;
		Product product = repository.findById(id).get();
		
		// update entity information
		product.setName("updated product 1");
		
		// save product
		repository.save(product);
				
	}

}
