package com.library.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.library.demo.data.model.BookModel;
import com.library.demo.data.repository.BookRepository;

@Service
public class BookService {
	@Autowired
	private BookRepository bookRepository;
	@Transactional
	public void addBook(BookModel book)
	{
		bookRepository.save(book);
	}
	@Transactional
	public void deleteBook(int bookId)
	{
		BookModel bookmodel=bookRepository.getOne(bookId);
		bookRepository.delete(bookmodel);
	}
	@Transactional
	public void editBook(int bookId ,BookModel book)
	{
		book.setBookId(bookId);
		bookRepository.save(book);
	}

	@Transactional
	public List<BookModel> getBooks()
	{
		return bookRepository.findAll();
	}
	@Transactional
	public List<BookModel> getBook(String genre)
	{
		return bookRepository.findByGenre(genre);
	}
	
}
