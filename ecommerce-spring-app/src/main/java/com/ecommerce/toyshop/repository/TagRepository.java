package com.ecommerce.toyshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.toyshop.entities.Tag;

public interface TagRepository extends JpaRepository<Tag, Long>{
	
	Tag findByName(String name);

}
