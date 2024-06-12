package com.MyKarsol.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.MyKarsol.Entity.Book;

public interface BookRepo extends JpaRepository<Book, Integer> {

}
