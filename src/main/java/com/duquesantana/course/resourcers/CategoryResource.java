package com.duquesantana.course.resourcers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.duquesantana.course.entities.Category;
import com.duquesantana.course.services.CategoryService;

//classe criada para testar o rest do spring boot

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {//CategoryResource depende do CategoryService assim necessita "component registration"
	
	@Autowired
	private CategoryService service;
	//abaixo metodo que será um end point para acessar os usuarios
	
	@GetMapping //anotation para indicar metodo q responde a requisicao do tipo get do http
	public ResponseEntity<List<Category>> findAll() { //ResponseEntity: tipo especifico para retornar respostas de requisicoes web
		List<Category> list = service.findAll();//busca lá no serviço
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Category> findById(@PathVariable Long id){//para spring aceitar id e considerar como parm precida da annotation PathVariable
		Category obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	

}
