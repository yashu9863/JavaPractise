package com.authorws.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.authorws.app.model.Authors;

public interface AuthorRepository extends JpaRepository<Authors, Long> {
	
	//public List<Authors>findByfName(String Sai);

}
