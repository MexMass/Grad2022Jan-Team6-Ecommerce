package com.ecommerce.toyshop.repository.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ecommerce.toyshop.entities.Product;
import com.ecommerce.toyshop.entities.Tag;
import com.ecommerce.toyshop.repository.ProductRepository;
import com.ecommerce.toyshop.repository.TagRepository;

import static org.assertj.core.api.Assertions.assertThat;

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
	
	//JUnit test for finding all products
		@Test
		public void givenProductList_whenFindAll_thenProductList() {

			//given - precondition or setup

			//when - behaviour or action that is tested
			Iterable<Product> products = repository.findAll();

			//then - verify output
			products.forEach((element)->{assertThat(element).isNotNull();});
		}
		
		//JUnit test for finding a product by id
		@Test
		public void givenProductId_whenFindById_thenProduct() {

			//given - precondition or setup
			Long id = 1L;
			
			//when - behaviour or action that is tested
			Optional<Product> product = repository.findById(id);

			//then - verify output
			assertThat(product).isNotNull();
			
		}
		
		//JUnit test for finding products by tags
		@Test
		public void givenTag_whenFindAllByTag_thenProductList(){
			
			//given - precondition or setup
			String tag = "softtoys";
			
			//when - behaviour or action being tested
			Iterable<Product> tagProducts = repository.findAllByTag(tag);
			
			//then - verify output
			tagProducts.forEach((element)->{assertThat(element).isNotNull();});
			
		}
		
		//JUnit test for finding product by tag when given no tag
		@Test
		public void givenNoTag_whenFindAllByTag_thenNull() {

			//given - precondition or setup
			String tag = "";

			//when - behaviour or action that is tested
			Iterable<Product> tagProducts = repository.findAllByTag(tag);

			//then - verify output
			tagProducts.forEach((element)->{assertThat(element).isNull();});

		}

}
