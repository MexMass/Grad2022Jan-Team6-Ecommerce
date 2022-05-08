package com.training.springboot.jpa.entities;


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

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "products", schema = "public")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
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
	
//	@ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.DETACH}, fetch = FetchType.EAGER)
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
	

}
