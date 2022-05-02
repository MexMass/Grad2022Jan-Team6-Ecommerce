package com.ecommerce.toyshop.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Review {
	
	@Id
	private long id;
	
	private User user;
	
	private Product product;
	
	private int score;
	
	private String description;
}
