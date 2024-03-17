package com.thymleaf.thymleaf.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDetailDto extends CategoryDto {
	private String aciklama;
}
