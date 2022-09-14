package com.duquesantana.course.resourcers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.duquesantana.course.entities.User;

//classe criada para testar o rest do spring boot

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	//abaixo metodo que será um end point para acessar os usuarios
	
	@GetMapping //anotation para indicar metodo q responde a requisicao do tipo get do http
	public ResponseEntity<User> findAll() { //ResponseEntity: tipo especifico para retornar respostas de requisicoes web
		User u = new User(1L, "Maria", "maria@gmail.com", "9999999", "12345");
		return ResponseEntity.ok().body(u);
		
	}

}
