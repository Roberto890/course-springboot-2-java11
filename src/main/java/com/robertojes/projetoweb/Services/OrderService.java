package com.robertojes.projetoweb.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.robertojes.projetoweb.entities.Order;
import com.robertojes.projetoweb.repositories.OrderRepository;

// anotação pra virar componente @Component
// anotação pra virar repositorio (mais especifico) @Repository
@Service //anotação pra virar serviço (mais especifico) e no caso é um serviço mesmo
public class OrderService {
	
	@Autowired
	private OrderRepository repository;
	
	public List<Order> findAll(){
		return repository.findAll();
	}
	
	public Order findById(Long id) {
		Optional<Order> obj = repository.findById(id);
		return obj.get();
	}
}
