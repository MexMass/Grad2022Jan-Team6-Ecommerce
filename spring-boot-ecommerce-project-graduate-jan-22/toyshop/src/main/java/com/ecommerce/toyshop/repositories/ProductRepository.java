package com.ecommerce.toyshop.repositories;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.ecommerce.toyshop.entities.Product;

public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {

}
