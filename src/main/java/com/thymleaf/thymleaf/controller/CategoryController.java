package com.thymleaf.thymleaf.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thymleaf.thymleaf.data.dto.CategoryDetailDto;
import com.thymleaf.thymleaf.data.dto.CategoryDto;
import com.thymleaf.thymleaf.data.dto.request.CategoryAddRequestDto;
import com.thymleaf.thymleaf.service.CategoryService;
import com.thymleaf.thymleaf.util.SuccessBuilder;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller

@RequiredArgsConstructor
public class CategoryController {
	private final CategoryService service;

	// ekleme
	@GetMapping("category/add")
	public String getCategoryAdd(Model model) {
		model.addAttribute("newCategory", new CategoryAddRequestDto());
		return "/category/category-add";
	}

	@PostMapping("category/add")
	public String addCategory(@Valid @ModelAttribute("newCategory") CategoryAddRequestDto dto) {
		service.add(dto);

		return "redirect:/category";
	}

	// listeleme

	
	@RequestMapping({"/category","/category/"})
	public String getByAll(Model model) {
		List<CategoryDto> categories = service.getByAll();
		model.addAttribute("categories", categories);

		return "/category/category-list";
	}

	// update
	@GetMapping("/category/update/{id}")
	public String getUpdate(@PathVariable Long id, Model model) {
		CategoryDetailDto cat = service.getById(id);
		model.addAttribute("kategori", cat);
		return "/category/category-update";
	}

	@PostMapping("/category/update")
	public String postUpdate(@ModelAttribute("kategori") CategoryDetailDto dto) {
		service.update(dto.getId(), dto);

		return "redirect:/category";
	}

	// category-detail

	@GetMapping("/category/detail/{id}")
	public String getById(@PathVariable Long id, Model model) {
		CategoryDetailDto dto=service.getById(id);
		model.addAttribute("kategori",dto);
		return "/category/category-detail";
	}

	


	@GetMapping("/category/delete/{id}")
	public String delete(@PathVariable Long id) {
		service.delete(id);
		return "redirect:/category";
	}

	

}
