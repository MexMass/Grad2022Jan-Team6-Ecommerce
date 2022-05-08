package com.ecommerce.toyshop.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/*
 *  Object for data transfer. ProductDTO values (from angular) -> Product values (saved in back end)
 */

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
	

	private String name;
	

	private String supplier_name;
	

	private int units_in_stock;
	

	private int total_price;
	
    private String[] tags; // receive the name of tags from front end/angular. Names will be searched with tagRepository and added when saving product.	

	private boolean discontinued;
	

	private String image_url;

}
