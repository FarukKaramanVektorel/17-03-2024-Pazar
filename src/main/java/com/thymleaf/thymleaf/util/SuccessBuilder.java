package com.thymleaf.thymleaf.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SuccessBuilder {	
	private Boolean durum;
	private String message;

}
