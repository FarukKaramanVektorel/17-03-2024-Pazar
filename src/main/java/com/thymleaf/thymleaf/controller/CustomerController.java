package com.thymleaf.thymleaf.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thymleaf.thymleaf.data.dto.CustomerDto;
import com.thymleaf.thymleaf.data.dto.request.CustomerAddRequestDto;
import com.thymleaf.thymleaf.service.CustomerService;
import com.thymleaf.thymleaf.util.SuccessBuilder;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customer")
public class CustomerController {
	private final CustomerService service;
	
	@PostMapping("/add")
	public SuccessBuilder add(@RequestBody CustomerAddRequestDto dto) {
		return service.add(dto);
	}
	
	@DeleteMapping("/{id}")
	public SuccessBuilder delete(@PathVariable Long id) {
		return service.delete(id);
	}
	
	@PutMapping("update")
	public SuccessBuilder update(@RequestBody CustomerDto dto) {
		return service.update(dto.getId(), dto);
	}
	@GetMapping("/")
	public List<CustomerDto> getByAll(){
		return service.getByAll();
	}
	
	@GetMapping("/{id}")
	public CustomerDto getById(Long id) {
		return service.getById(id);
	}
}
