package com.library.demo.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.demo.data.model.BookModel;

public interface BookRepository extends JpaRepository<BookModel,Integer> {
	List<BookModel> findByGenre(String genre);
 
}
