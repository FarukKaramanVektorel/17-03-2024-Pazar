package com.thymleaf.thymleaf.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thymleaf.thymleaf.data.enity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
