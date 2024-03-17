package com.thymleaf.thymleaf.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.thymleaf.thymleaf.data.dto.ProductDto;
import com.thymleaf.thymleaf.data.dto.request.ProductAddRequestDto;
import com.thymleaf.thymleaf.data.enity.Category;
import com.thymleaf.thymleaf.data.enity.Product;
import com.thymleaf.thymleaf.repository.CategoryRepository;
import com.thymleaf.thymleaf.repository.ProductRepository;
import com.thymleaf.thymleaf.util.ResponseUtil;
import com.thymleaf.thymleaf.util.SuccessBuilder;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {
	public final ProductRepository repository;
	public final CategoryRepository cRepository;
	public final ModelMapper mapper;

	// CRUD
	// Create Read Update Delete

	public ProductDto getById(Long id) {
		return mapper.map(repository.findById(id).orElse(null), ProductDto.class);
	}

	public List<ProductDto> getByAll() {
		List<Product> prods = repository.findAll();		
		return prods.stream().map(p -> mapper.map(p, ProductDto.class))
				.collect(Collectors.toList());
	}

	public SuccessBuilder add(ProductAddRequestDto dto) {
		Product prod = mapper.map(dto, Product.class);
		if (prod != null) {
			repository.save(prod);
			return ResponseUtil.buildSuccess();
		} else {
			return ResponseUtil.buildError();
		}

	}

	public SuccessBuilder update(Long id, ProductDto dto) {
		if (repository.existsById(id)) {
			Product prod = repository.findById(id).orElse(null);
			prod.setName(dto.getName());
			Category cat = cRepository.findById(dto.getCategory().getId())
					.orElseThrow(() -> new RuntimeException("Kategori Bulunamadı ID: " + dto.getCategory().getId()));
			prod.setCategory(cat);
			repository.save(prod);
			return ResponseUtil.buildSuccess();
		} else {
			return ResponseUtil.buildError();
		}
	}

	public SuccessBuilder delete(Long id) {
		if (repository.existsById(id)) {
			Product prod = repository.findById(id).orElse(null);
			repository.delete(prod);
			return ResponseUtil.buildSuccess();
		} else {
			return ResponseUtil.buildError();
		}

	}

}
