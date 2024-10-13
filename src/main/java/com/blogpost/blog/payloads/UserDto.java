package com.blogpost.blog.payloads;




import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {

	
	private int id;
	
	@NotEmpty(message = "Requied compalsary")
	@Size(max = 4, message = "Username must be min of 4 characters")
	private String name;

	@Email(message = "Email address not valid")
	private String email;
	
	@NotEmpty
	@Size(min = 3,max = 10,message = "Password must be min of 3 and max 10 characters")
	private String password;
	
	@jakarta.validation.constraints.NotEmpty
	private String about;
}
