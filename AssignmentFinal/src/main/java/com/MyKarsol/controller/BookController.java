package com.MyKarsol.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MyKarsol.Entity.Book;
import com.MyKarsol.Entity.EmailDetail;
import com.MyKarsol.service.BookService;
import com.MyKarsol.service.SendEmailService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/book")
public class BookController 
{
	Logger logger = LoggerFactory.getLogger(BookController.class);
	@Autowired
	private BookService service;
	
	@Autowired
	private SendEmailService emailService;

	@GetMapping("/{id}")
	public ResponseEntity<Book> getBook(@PathVariable("id")int id) {
		logger.info("getBook Message has been called");
		logger.error("check the error works");
		return new ResponseEntity<Book>(service.getBookById(id),HttpStatus.OK); 	
		}
	
	@GetMapping("/all")
	public ResponseEntity<List<Book>> getAll() {
		return new ResponseEntity<List<Book>>(service.getAllBook(),HttpStatus.OK);
	}
	
	@PostMapping("/save")
	public ResponseEntity<String> saveBook(@Valid @RequestBody Book book) {
		 service.saveBook(book);
		 return new ResponseEntity<String>("Book Saved", HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteBook(@PathVariable int id) {
		 service.deleteBook(id);
		 return new ResponseEntity<String>("Book deleted",HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Book> updateBook(@Valid @RequestBody Book book) {
		return new ResponseEntity<Book>(service.updateBook(book.getId(),book),HttpStatus.OK);
	}
	
	@PostMapping("/sendEmail")
	public ResponseEntity<String> sendEmail(@RequestBody EmailDetail email) {
		emailService.sendEmail(email);
		return new ResponseEntity<String>("Email send Successfully",HttpStatus.OK);
	}
}
