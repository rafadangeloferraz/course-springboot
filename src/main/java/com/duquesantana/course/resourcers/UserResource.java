package com.duquesantana.course.resourcers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.duquesantana.course.entities.User;
import com.duquesantana.course.services.UserService;

//classe criada para testar o rest do spring boot

@RestController
@RequestMapping(value = "/users")
public class UserResource {//UserResource depende do UserService assim necessita "component registration"
	
	@Autowired
	private UserService service;
	//abaixo metodo que será um end point para acessar os usuarios
	
	@GetMapping //anotation para indicar metodo q responde a requisicao do tipo get do http
	public ResponseEntity<List<User>> findAll() { //ResponseEntity: tipo especifico para retornar respostas de requisicoes web
		List<User> list = service.findAll();//busca lá no serviço
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id){//para spring aceitar id e considerar como parm precida da annotation PathVariable
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User obj) { //@RequestBody para dizer q obj User vai chegar no modo json na hora de fazer requisição e esse json vai ser deserealizado para um objeto user no java
		obj = service.insert(obj);
		//objeto uri contem o cabeçalho contendo o endereço do novo recurso inserido 
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
		
		//return ResponseEntity.ok().body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User obj) {
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
	
}
