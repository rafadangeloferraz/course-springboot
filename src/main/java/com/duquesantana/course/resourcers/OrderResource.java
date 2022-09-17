package com.duquesantana.course.resourcers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.duquesantana.course.entities.Order;
import com.duquesantana.course.services.OrderService;

//classe criada para testar o rest do spring boot

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {//OrderResource depende do OrderService assim necessita "component registration"
	
	@Autowired
	private OrderService service;
	//abaixo metodo que será um end point para acessar os usuarios
	
	@GetMapping //anotation para indicar metodo q responde a requisicao do tipo get do http
	public ResponseEntity<List<Order>> findAll() { //ResponseEntity: tipo especifico para retornar respostas de requisicoes web
		List<Order> list = service.findAll();//busca lá no serviço
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Order> findById(@PathVariable Long id){//para spring aceitar id e considerar como parm precida da annotation PathVariable
		Order obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	

}
