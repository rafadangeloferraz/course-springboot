package com.duquesantana.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duquesantana.course.entities.Product;
import com.duquesantana.course.repositories.ProductRepository;

@Service// esse é o "component registration" para utilizar no ProductResource
public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	
	public List<Product> findAll() {
		return repository.findAll();
	}
	
	public Product findById(Long id) {
		Optional<Product> obj = repository.findById(id);//
		return obj.get();
	}

}
