package com.ecommerce.toyshop.services.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ecommerce.toyshop.entities.Discount;
import com.ecommerce.toyshop.services.DiscountService;

@SpringBootTest
public class DiscountServiceTest {
	
	@Autowired
	DiscountService discountService;
	
	//JUnit test for service to get discount by product id
	@Test
	public void givenId_whenGetDiscount_thenDiscount() {

		//given - precondition or setup
		int productId = 2;
		
		//when - behaviour or action that is tested
		Optional<Discount> discountOptional = discountService.getDiscount((long)productId);

		//then - verify output
		Discount discount = discountOptional.get();
		assertThat(discount.getProduct_id()).isEqualTo((long)productId);

	}
}
