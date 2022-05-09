package com.ecommerce.toyshop.repository.test;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ecommerce.toyshop.entities.Discount;
import com.ecommerce.toyshop.repository.DiscountRepository;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class DiscountRepositoryTest {
	
	@Autowired
	DiscountRepository discountRepo;
	
	//JUnit test for
	@Test
	public void givenId_whenDiscountById_thenDiscount() {

		//given - precondition or setup
		int productId = 2;

		//when - behaviour or action that is tested
		Optional<Discount> discountOptional = discountRepo.discountByProductId(productId);
		
		//then - verify output
		Discount discount = discountOptional.get();
		
		assertThat(discount.getProduct_id()).isEqualTo((long)productId);
	}
}
