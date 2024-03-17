package com.thymleaf.thymleaf.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thymleaf.thymleaf.data.enity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
