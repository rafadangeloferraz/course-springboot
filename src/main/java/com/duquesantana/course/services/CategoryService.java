package com.duquesantana.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duquesantana.course.entities.Category;
import com.duquesantana.course.repositories.CategoryRepository;

@Service// esse é o "component registration" para utilizar no CategoryResource
public class CategoryService {
	
	@Autowired
	private CategoryRepository repository;
	
	public List<Category> findAll() {
		return repository.findAll();
	}
	
	public Category findById(Long id) {
		Optional<Category> obj = repository.findById(id);//
		return obj.get();
	}

}
