package com.thymleaf.thymleaf.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thymleaf.thymleaf.data.enity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
