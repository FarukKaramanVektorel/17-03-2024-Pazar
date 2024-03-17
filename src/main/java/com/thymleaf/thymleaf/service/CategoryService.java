package com.thymleaf.thymleaf.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.thymleaf.thymleaf.data.dto.CategoryDetailDto;
import com.thymleaf.thymleaf.data.dto.CategoryDto;
import com.thymleaf.thymleaf.data.dto.request.CategoryAddRequestDto;
import com.thymleaf.thymleaf.data.enity.Category;
import com.thymleaf.thymleaf.repository.CategoryRepository;
import com.thymleaf.thymleaf.util.ResponseUtil;
import com.thymleaf.thymleaf.util.SuccessBuilder;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryService {
	private final CategoryRepository repository;
	private final ModelMapper mapper;

	public SuccessBuilder add(CategoryAddRequestDto dto) {
		if (dto.getName() == null||dto.getName().equals("")) {
			throw new RuntimeException("Ad alanı boş bırakılamaz");
		} else {
			Category cat = repository.save(mapper.map(dto, Category.class));
			if (cat != null) {
				return ResponseUtil.buildSuccess("Kategori Kaydı Başarılı");
			} else {
				return ResponseUtil.buildError("Kategori Kaydı Başarısız");
			}
		}

	}

	public List<CategoryDto> getByAll() {
		List<Category> cats = repository.findAll();
		return cats.stream().map(cat -> mapper.map(cat, CategoryDto.class)).collect(Collectors.toList());
	}

	public CategoryDetailDto getById(Long id) {
		return mapper.map(repository.findById(id).orElse(null), CategoryDetailDto.class);
	}

	public SuccessBuilder update(Long id, CategoryDetailDto dto) {
		Category cat = repository.findById(id).orElse(null);
		if (cat != null) {
			cat.setName(dto.getName());
			cat.setAciklama(dto.getAciklama());
			repository.save(cat);
			return ResponseUtil.buildSuccess("Kategori Güncelleme Başarılı");
		} else {
			return ResponseUtil.buildError("Kategori Id Bulunamadı: " + id);
		}

	}

	public SuccessBuilder delete(Long id) {
		Category cat = repository.findById(id).orElse(null);
		if (cat != null) {
			repository.delete(cat);
			return ResponseUtil.buildSuccess("Kategori Silme Başarılı");
		} else {
			return ResponseUtil.buildError("Kategori Id Bulunamadı: " + id);
		}

	}

}
