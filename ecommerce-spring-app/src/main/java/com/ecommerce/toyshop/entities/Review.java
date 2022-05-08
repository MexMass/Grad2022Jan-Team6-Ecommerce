package com.ecommerce.toyshop.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="reviews")
public class Review {
	
	@Id
	private long id;
	
	private long user_id;
	
	private long product_id;
	
	private int score;
	
	private String description;
	

	public Review() {
	}

	public Review(long id, long user_id, long product_id, int score, String description) {
		this.id = id;
		this.user_id = user_id;
		this.product_id = product_id;
		this.score = score;
		this.description = description;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


	public long getUser_id() {
		return user_id;
	}

	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}

	public long getProduct_id() {
		return product_id;
	}

	public void setProduct_id(long product_id) {
		this.product_id = product_id;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
