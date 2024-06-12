package com.MyKarsol.Entity;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class EmailDetail {
	
	@NotBlank(message="recipient is mandatory")
	private String recipient;
	
	@Max(250)
	private String body;
	
	@NotBlank(message ="subject is required")
	private String subject;

}
