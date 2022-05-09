package com.ecommerce.toyshop.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.toyshop.entities.Product;
import com.ecommerce.toyshop.entities.ProductDto;
import com.ecommerce.toyshop.services.ProductService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class ProductController {
	
	private ProductService productService;
	
	public ProductController(@Autowired ProductService service) {
		this.productService = service;
	}

	// this url will read data from query parameters
	// query parameters are appended at the end of URL after ?
	// http://localhost:8080/page/products?/pgnum=0&size=2
	@GetMapping(value = "/page/products", produces = "application/json")
	public List<Product> getProductsOnPage(@RequestParam("pgnum") int pageNumber, @RequestParam("size") int size) {
		List<Product> products = this.productService.getProductBasedOnPage(pageNumber, size);
		return products;
	}
	
	@GetMapping("/products")
	public ResponseEntity<List<Product>> getAllProducts() {
		List<Product> products = productService.findAll();
		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}
	
	@GetMapping(value = "/products/id/{id}", produces = "application/json")
	public Optional<Product> getProductById(@PathVariable("id") Long id) {
		Optional<Product> product = productService.findById(id);
		return product;
	}
	
	@GetMapping(value = "/products/tag/{tag}", produces = "application/json")
	public List<Product> getProductByTag(@PathVariable("tag") String tag) {
		List<Product> products = productService.findAllByTag(tag);
		return products;
	}

	@PostMapping(value = "/products/create",  consumes = "application/json")
	@ResponseBody // binds method return value to the web response body
	public ResponseEntity<String> createProduct(@RequestBody ProductDto productDto) { // get product details from request body
		productService.addNewProduct(productDto);
		return new ResponseEntity<String>("{\"response\": \"Product with name '" + productDto.getName() + "' created\"}",HttpStatus.CREATED); // send response back to front end
	}
	
	@PutMapping(value = "/products/discontinue",  consumes = "application/json")
	@ResponseBody // binds method return value to the web response body
	public ResponseEntity<String> discontinueProduct(@RequestBody long productId) { // get product details from request body
		String response = productService.discontinueProduct(productId);
		return new ResponseEntity<String>(response,HttpStatus.OK); // send response back to front end
//		return new ResponseEntity<String>("{\"response\": \"Product with name '" + product.getName() + "' discontinued\"}",HttpStatus.OK); // send response back to front end
	}
	
}
