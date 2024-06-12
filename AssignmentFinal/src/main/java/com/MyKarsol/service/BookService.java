package com.MyKarsol.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MyKarsol.Entity.Book;
import com.MyKarsol.repository.BookRepo;

import jakarta.transaction.Transactional;

@Service
public class BookService 
{

	@Autowired
	private BookRepo repo;
	
	public Book getBookById(int id) {
		return repo.findById(id).get();
	}

	public List<Book> getAllBook() {
		return repo.findAll();
	}

	@Transactional
	public void saveBook(Book book) {
		 repo.save(book);
	}

	@Transactional
	public void deleteBook(int id) {
		Book book =repo.findById(id).get();
        repo.delete(book);
	}

	/*
	 * Instead of manually update the data , we can use the MapStruct or ModelMapper 
	 * */
	@Transactional
	public Book updateBook(int id, Book updateBook) {
		Book bookOld = repo.findById(id).get();
		
		bookOld.setTitle(updateBook.getTitle());
		bookOld.setDescription(updateBook.getDescription());
		bookOld.setStatus(true);
		bookOld.setPublicationDate(updateBook.getPublicationDate());
		bookOld.setAuthor(updateBook.getAuthor());
		repo.save(bookOld);
		return bookOld;
	}

}
