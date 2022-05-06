package com.ecommerce.toyshop.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="discounts")
public class Discount {
	
	
	@Id
	private long id;
	
	private long product_id;
	
	private int percent;
	
	public Discount() {
	}

	public Discount(long id, long product_id, int percent) {
		this.id = id;
		this.product_id = product_id;
		this.percent = percent;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


	public long getProduct_id() {
		return product_id;
	}

	public void setProduct_id(long product_id) {
		this.product_id = product_id;
	}

	public int getPercent() {
		return percent;
	}

	public void setPercent(int percent) {
		this.percent = percent;
	}

	
}
