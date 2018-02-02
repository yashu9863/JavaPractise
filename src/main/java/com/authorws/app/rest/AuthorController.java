package com.authorws.app.rest;



import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.authorws.app.model.Authors;
import com.authorws.app.service.AuthorService;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {
	
	@Autowired
	private AuthorService authorService;
	
	@GetMapping(path="/all")
	public List<Authors>getAll() throws Exception{
		
		/*
		List<Authors>authors = new ArrayList<Authors>(); 
		
		authors.add(new Authors("Sai", "SS"));
		authors.add(new Authors("Sam", "Henry"));
		authors.add(new Authors("Mike", "Dan"));
		authors.add(new Authors("Jin", "chao"));
		*/
		List<Authors>authors = authorService.getAll();
		return authors;
		}
	
	public Authors getAuthor() {	
		Authors a = new Authors("Sampath", "Silla");
		return a;
	}
	
	@GetMapping("/{id}")//local:8080/api/authors/10
	public Authors getAuthorPath(@PathVariable("id")Long id) throws Exception {
		Authors authors = authorService.getAuotherbyId(id);
		//Authors a = new Authors("Prakash", "Sirra");
		return authors;
	}
	
	@PostMapping
	public Authors create(@Valid @RequestBody Authors author) throws Exception {
		Authors savedAuthor = authorService.create(author);
		return savedAuthor;
	}
	
	@PutMapping 
	public Authors update(@RequestBody Authors author) throws Exception {
		Authors authors = authorService.updateAuother(author);
		return authors;
	}
	
	@PutMapping("/{id}") 
	public Authors updateById(@RequestBody Authors author) throws Exception {
		Authors authors = authorService.updateAuotherbyId(author);
		return authors;
	}
	@DeleteMapping("/{id}")//local:8080/api/authors/10
	public HttpStatus delete(@PathVariable("id")Long id) throws Exception {
		authorService.delete(id);
		return HttpStatus.OK;
	}
}
