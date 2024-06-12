package com.MyKarsol.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
public class Author 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int authorId;
	@NotBlank(message = "auther name is required")
	private String name;
	
	@Email(message = "email is invalid")
	private String email;
	
	@NotNull(message="age is required")
	private int age;
}
