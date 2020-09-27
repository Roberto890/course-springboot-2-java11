package com.robertojes.projetoweb.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.robertojes.projetoweb.entities.Product;
import com.robertojes.projetoweb.repositories.ProductRepository;

// anotação pra virar componente @Component
// anotação pra virar repositorio (mais especifico) @Repository
@Service //anotação pra virar serviço (mais especifico) e no caso é um serviço mesmo
public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	
	public List<Product> findAll(){
		return repository.findAll();
	}
	
	public Product findById(Long id) {
		Optional<Product> obj = repository.findById(id);
		return obj.get();
	}
}
