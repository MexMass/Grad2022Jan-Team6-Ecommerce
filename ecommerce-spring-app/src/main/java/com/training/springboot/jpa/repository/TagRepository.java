package com.training.springboot.jpa.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.springboot.jpa.entities.Tag;

public interface TagRepository extends JpaRepository<Tag, Long>{
	
	Tag findByName(String name);

}
