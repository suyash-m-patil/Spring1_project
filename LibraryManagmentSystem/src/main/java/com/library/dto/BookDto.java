package com.library.dto;

import javax.persistence.Entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BookDto {
	
	@NotNull(message = "Name can not be null")
	@NotBlank(message = "Name can't be Blank")
		String bName;
		
	    int bPrice;
	    @NotNull(message = "Name can not be null")
		@NotBlank(message = "Name can't be Blank")
	    String bAuthorName;

	}

