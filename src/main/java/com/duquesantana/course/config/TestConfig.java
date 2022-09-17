package com.duquesantana.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.duquesantana.course.entities.Category;
import com.duquesantana.course.entities.Order;
import com.duquesantana.course.entities.User;
import com.duquesantana.course.entities.enums.OrderStatus;
import com.duquesantana.course.repositories.CategoryRepository;
import com.duquesantana.course.repositories.OrderRepository;
import com.duquesantana.course.repositories.UserRepository;

//classe especifica de confirguração e popula bd com alguns objs / classe auxiliar

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner { //CommandLineRunner executa qdo pgm for iniciado
	//injeção de dependencia fraca, desacoplada (imnplicito) para salvar os dados pois quem faz eh o repository
	@Autowired //o proprio spring qdo estiver rodando a aplicação vai resolver a dependencia e associar uma instancioa de userReposotiry
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u1);
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
	}
			
}
