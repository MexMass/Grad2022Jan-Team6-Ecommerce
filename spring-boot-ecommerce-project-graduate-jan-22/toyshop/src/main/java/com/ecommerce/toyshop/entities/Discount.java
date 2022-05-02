package com.ecommerce.toyshop.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Discount {

	@Id
	private long id;
	
	private Product product;
	
	private int percent;
}
