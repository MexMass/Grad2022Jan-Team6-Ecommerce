package com.ecommerce.toyshop.entities;

/*
 *  Object for data transfer. ProductDTO values (from angular) -> Product values (saved in back end)
 */

public class ProductDto {
	

	private String name;
	

	private String supplier_name;
	

	private int units_in_stock;
	

	private int total_price;
	
    private String[] tags; // receive the name of tags from front end/angular. Names will be searched with tagRepository and added when saving product.	

	private boolean discontinued;
	

	private String image_url;

	

	public ProductDto() {
	}


	public ProductDto(String name, String supplier_name, int units_in_stock, int total_price, String[] tags,
			boolean discontinued, String image_url) {
		this.name = name;
		this.supplier_name = supplier_name;
		this.units_in_stock = units_in_stock;
		this.total_price = total_price;
		this.tags = tags;
		this.discontinued = discontinued;
		this.image_url = image_url;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getSupplier_name() {
		return supplier_name;
	}


	public void setSupplier_name(String supplier_name) {
		this.supplier_name = supplier_name;
	}


	public int getUnits_in_stock() {
		return units_in_stock;
	}


	public void setUnits_in_stock(int units_in_stock) {
		this.units_in_stock = units_in_stock;
	}


	public int getTotal_price() {
		return total_price;
	}


	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}


	public String[] getTags() {
		return tags;
	}


	public void setTags(String[] tags) {
		this.tags = tags;
	}


	public boolean isDiscontinued() {
		return discontinued;
	}


	public void setDiscontinued(boolean discontinued) {
		this.discontinued = discontinued;
	}


	public String getImage_url() {
		return image_url;
	}


	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}
	
	
}
