package com.ecommerce.toyshop.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="products")
public class Product {
	
	@Id
	private long id;
	
	private String name;
	
	@Column(name="supplier_name")
	private String supplierName;
	
	@Column(name="units_in_stock")
	private int unitsInStock;
	
	@Column(name="total_price")
	private int unitPrice;
	
	private boolean discontinued;
	
	
	public Product() {
	}

	public Product(long id, String name, String supplierName, int unitsInStock, int unitPrice, boolean discontinued,
			String imageUrl) {
		this.id = id;
		this.name = name;
		this.supplierName = supplierName;
		this.unitsInStock = unitsInStock;
		this.unitPrice = unitPrice;
		this.discontinued = discontinued;
		this.imageUrl = imageUrl;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public int getUnitsInStock() {
		return unitsInStock;
	}

	public void setUnitsInStock(int unitsInStock) {
		this.unitsInStock = unitsInStock;
	}

	public int getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}

	public boolean isDiscontinued() {
		return discontinued;
	}

	public void setDiscontinued(boolean discontinued) {
		this.discontinued = discontinued;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	@Column(name="image_url")
	private String imageUrl;
}
