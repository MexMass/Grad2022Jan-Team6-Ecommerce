package com.ecommerce.toyshop.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="discounts")
public class Discount {
	
	
	@Id
	private long id;
	
	private Product product;
	
	private int percent;
	
	public Discount() {
	}

	public Discount(long id, Product product, int percent) {
		this.id = id;
		this.product = product;
		this.percent = percent;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getPercent() {
		return percent;
	}

	public void setPercent(int percent) {
		this.percent = percent;
	}

	
}
