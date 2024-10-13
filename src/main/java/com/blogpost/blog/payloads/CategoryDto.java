package com.blogpost.blog.payloads;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CategoryDto {

	private Integer categoryId;
	@NotBlank()
	@Size(min = 4)
	private String categoryTitle;
	@NotBlank
	@Size(min = 10,message = "Description should be like greater than 10 charaters")
	private String categoryDescription; 
}
