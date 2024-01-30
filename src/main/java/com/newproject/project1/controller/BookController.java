package com.newproject.project1.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.newproject.project1.model.Book;
import com.newproject.project1.repo.Bookrepository;

@RestController
public class BookController {

	@Autowired
	private Bookrepository bookrepository;

	@PostMapping("/save")
	public String insertBook(@RequestBody Book book) {
		bookrepository.save(book);
		return "your record is saved successfully";

	}
	

	@PostMapping("/saveAllBook")
	public String insertBook(@RequestBody List<Book> book) {
		bookrepository.saveAll(book);
		return "record is saved successfully";
	}
	
	@GetMapping("/getAllBooks")
	public List<Book> getAllBook(){
		return bookrepository.findAll();
	}
	
	@GetMapping("/getBook/{id}")
	public Optional<Book> bookById(@PathVariable("id") long id) {
		if(bookrepository.findById(id) !=null) {
			  return bookrepository.findById(id);
		}else {
			return null;
		}
		
		
	}
	
	@DeleteMapping("/deleteBook/{id}")
	public String deleteById(@PathVariable("id") long id) {
		String response=null;
		try {
			if(bookrepository.findById(id) !=null) {
				bookrepository.deleteById(id);
				response= "Book with id:"+id +" deleted successfully !";
			}
		} catch (Exception e) {
			// TODO: handle exception
			response= "Book with id:"+id +" not found !";
		}
		return response;
		
	}

	
	@DeleteMapping("/deleteAllBook")
	public String deleteAllBook() {
		bookrepository.deleteAll();
		return "All Books Deleted";
	}
}