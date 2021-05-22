package com.library.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.library.demo.data.model.BookModel;
import com.library.demo.service.BookService;

@RestController
public class BookController {
	@Autowired
	BookService bookService;
    @PostMapping(value="/saveBook")
    public String addBook(@RequestBody BookModel book)
    {
    	bookService.addBook(book);
    	return "Inserted";
    }
    @PostMapping(value="/deleteBook")
    public String deleteBook(@RequestParam("bookId") int bookId)
    {
    	bookService.deleteBook(bookId);
    	return "Deleted Successfully";
    }
    @PostMapping(value="/editBook")
    public String editBook(@RequestParam("bookId") int bookId,@RequestBody BookModel book)
    {
    	bookService.editBook(bookId,book);
    	return "Edited";
    }
    @GetMapping(value="/getBooks")
    
    	public List<BookModel> getBooks()
    	{
    	 return bookService.getBooks();
    	}
    
    @PostMapping(value="/getByType")
    
	public List<BookModel> getBook(@RequestParam("genre") String genre)
	{
	 return bookService.getBook(genre);
	 
	}
}
