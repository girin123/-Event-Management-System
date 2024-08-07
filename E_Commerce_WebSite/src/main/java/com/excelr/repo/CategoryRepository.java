package com.excelr.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.excelr.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
	
	
}