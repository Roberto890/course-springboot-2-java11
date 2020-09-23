package com.robertojes.projetoweb.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.robertojes.projetoweb.entities.User;
import com.robertojes.projetoweb.repositories.UserRepository;

@Configuration
@Profile("test") // é o teste la do application.properties no resources
public class TestConfig implements CommandLineRunner{
	
	//quando usa framework as vezes tem mecanismo automatico de injeção de dependencia
	//no caso o springboot da é so usar o autowired
	//ja q o userRepository tem os bang pra rodar os negocio no banco
	@Autowired
	private UserRepository userRepository;
	
	
	// tudo q tiver dentro do metodo vai ser rodado
	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		//save all salva no banco ai usa array pra usar os 2 usuarios
		userRepository.saveAll(Arrays.asList(u1,u2));
	}
}
