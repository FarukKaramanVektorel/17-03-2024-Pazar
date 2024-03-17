package com.thymleaf.thymleaf.data.dto.response;

import java.util.List;

import com.thymleaf.thymleaf.data.dto.ProductDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryWitdhProductResponseDto {
	private Long cat_id;
	private String kategori;
	private Long urun_id;
	private String urun;
}
