package com.duquesantana.course.resourcers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.duquesantana.course.entities.Product;
import com.duquesantana.course.services.ProductService;

//classe criada para testar o rest do spring boot

@RestController
@RequestMapping(value = "/products")
public class ProductResource {//ProductResource depende do ProductService assim necessita "component registration"
	
	@Autowired
	private ProductService service;
	//abaixo metodo que será um end point para acessar os usuarios
	
	@GetMapping //anotation para indicar metodo q responde a requisicao do tipo get do http
	public ResponseEntity<List<Product>> findAll() { //ResponseEntity: tipo especifico para retornar respostas de requisicoes web
		List<Product> list = service.findAll();//busca lá no serviço
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id){//para spring aceitar id e considerar como parm precida da annotation PathVariable
		Product obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	

}
