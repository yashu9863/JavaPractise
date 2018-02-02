package com.authorws.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.authorws.app.exceptions.NotFoundException;
import com.authorws.app.model.Authors;
import com.authorws.app.repository.AuthorRepository;

@Service
public class AuthorService {

	@Autowired
	private AuthorRepository authorRepository;
	
	public Authors create(Authors author) throws Exception {
		return authorRepository.save(author);
	}
	
	public List<Authors> getAll() throws Exception{
		return authorRepository.findAll();
	}
	
	public Authors getAuotherbyId(Long id) throws Exception{
		return authorRepository.findOne(id);
	}
	
	public Authors updateAuother(Authors author) throws Exception{
		return authorRepository.save(author);
	}
	
	public Authors updateAuotherbyId(Authors author) throws Exception{
		return authorRepository.save(author);
	}
	
	
	public void delete(Long id) throws Exception{
		Authors author = authorRepository.findOne(id);
		if(author == null) {
			throw new NotFoundException("Author with id: "+ id +" is not found");
		}
		authorRepository.delete(id);
	}
}
