package com.robertojes.projetoweb.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.robertojes.projetoweb.entities.Category;
import com.robertojes.projetoweb.entities.Order;
import com.robertojes.projetoweb.entities.User;
import com.robertojes.projetoweb.entities.enums.OrderStatus;
import com.robertojes.projetoweb.repositories.CategoryRepository;
import com.robertojes.projetoweb.repositories.OrderRepository;
import com.robertojes.projetoweb.repositories.UserRepository;

@Configuration
@Profile("test") // é o teste la do application.properties no resources
public class TestConfig implements CommandLineRunner{
	
	//quando usa framework as vezes tem mecanismo automatico de injeção de dependencia
	//no caso o springboot da é so usar o autowired
	//ja q o userRepository tem os bang pra rodar os negocio no banco
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	
	// tudo q tiver dentro do metodo vai ser rodado
	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u1); 
		
		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers"); 
		
		//save all salva no banco ai usa array pra usar os 2 usuarios
		userRepository.saveAll(Arrays.asList(u1,u2));
		orderRepository.saveAll(Arrays.asList(o1,o2,o3));
		categoryRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
	}
}
