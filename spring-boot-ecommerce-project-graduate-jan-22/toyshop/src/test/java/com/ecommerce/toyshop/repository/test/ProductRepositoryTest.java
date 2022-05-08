package com.ecommerce.toyshop.repository.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import com.ecommerce.toyshop.entities.Product;
import com.ecommerce.toyshop.repositories.ProductRepository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

@SpringBootTest
public class ProductRepositoryTest {
	
	@Autowired
	private ProductRepository repo;
	
	//JUnit test for finding all products
	@Test
	public void givenProductList_whenFindAll_thenProductList() {

		//given - precondition or setup

		//when - behaviour or action that is tested
		Iterable<Product> products = repo.findAll();

		//then - verify output
		products.forEach((element)->{assertThat(element).isNotNull();});
	}
	
	//JUnit test for finding a product by id
	@Test
	public void givenProductId_whenFindById_thenProduct() {

		//given - precondition or setup
		Long id = 1L;
		
		//when - behaviour or action that is tested
		Optional<Product> product = repo.findById(id);

		//then - verify output
		assertThat(product).isNotNull();
		
	}
	
	//JUnit test for finding products by tags
	@Test
	public void givenTag_whenFindAllByTag_thenProductList(){
		
		//given - precondition or setup
		String tag = "softtoys";
		
		//when - behaviour or action being tested
		Iterable<Product> tagProducts = repo.findAllByTag(tag);
		
		//then - verify output
		tagProducts.forEach((element)->{assertThat(element).isNotNull();});
		
	}
	
	//JUnit test for finding product by tag when given no tag
	@Test
	public void givenNoTag_whenFindAllByTag_thenNull() {

		//given - precondition or setup
		String tag = "";

		//when - behaviour or action that is tested
		Iterable<Product> tagProducts = repo.findAllByTag(tag);

		//then - verify output
		tagProducts.forEach((element)->{assertThat(element).isNull();});

	}
}
