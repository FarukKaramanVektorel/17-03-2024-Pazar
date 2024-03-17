package com.thymleaf.thymleaf.data.dto;

import com.thymleaf.thymleaf.data.dto.response.ProductBaseDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto extends ProductBaseDto{
 private CategoryDto category;
}
