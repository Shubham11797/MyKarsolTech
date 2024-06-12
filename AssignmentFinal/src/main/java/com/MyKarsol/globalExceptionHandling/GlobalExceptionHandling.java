package com.MyKarsol.globalExceptionHandling;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandling 
{

	  @ExceptionHandler(NoSuchElementException.class)
	  public ResponseEntity<String> handlerResourceNotFound(NoSuchElementException e)
	  {
		  return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
		  
	  }
	  
	  
	  @ExceptionHandler(IllegalArgumentException.class)
	  public ResponseEntity<String> illegalArgsException(IllegalArgumentException e)
	  {
		  return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
	  }
	  
	  @ExceptionHandler(Exception.class)
	  public ResponseEntity<String> Exception(Exception e)
	  {
		  return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	  }
}
