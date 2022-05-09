package com.ecommerce.toyshop.entities;


import java.util.Collection;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.ToString;

@Entity
@Table(name = "products", schema = "public")
@ToString
public class Product {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "supplier_name", nullable = false)
	private String supplier_name;
	
	@Column(name = "units_in_stock", nullable = false)
	private int units_in_stock;
	
	@Column(name = "total_price", nullable = false)
	private int total_price;
	
    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.DETACH}, fetch = FetchType.EAGER)
    @JoinTable(
            name = "product_tags",
            schema = "public",
            joinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id", referencedColumnName = "id"))
    private Collection<Tag> tags;
	
	@Column(name = "discontinued", nullable = false)
	private boolean discontinued;
	
	@Column(name = "image_url", nullable = false)
	private String image_url;
	
	

	public Product(Long id, String name, String supplier_name, int units_in_stock, int total_price,
			Collection<Tag> tags, boolean discontinued, String image_url) {
		this.id = id;
		this.name = name;
		this.supplier_name = supplier_name;
		this.units_in_stock = units_in_stock;
		this.total_price = total_price;
		this.tags = tags;
		this.discontinued = discontinued;
		this.image_url = image_url;
	}
	
	
	public Product() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Collection<Tag> getTags() {
		return tags;
	}

	public void setTags(Collection<Tag> tags) {
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
