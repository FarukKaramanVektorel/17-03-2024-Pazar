package com.thymleaf.thymleaf.data.dto.request;

import com.thymleaf.thymleaf.data.dto.CategoryDto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductAddRequestDto {
	@NotNull
	private String name;
	private CategoryDto category;
}
