package com.robertojes.projetoweb.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.robertojes.projetoweb.entities.Category;
import com.robertojes.projetoweb.repositories.CategoryRepository;

// anotação pra virar componente @Component
// anotação pra virar repositorio (mais especifico) @Repository
@Service //anotação pra virar serviço (mais especifico) e no caso é um serviço mesmo
public class CategoryService {
	
	@Autowired
	private CategoryRepository repository;
	
	public List<Category> findAll(){
		return repository.findAll();
	}
	
	public Category findById(Long id) {
		Optional<Category> obj = repository.findById(id);
		return obj.get();
	}
}
