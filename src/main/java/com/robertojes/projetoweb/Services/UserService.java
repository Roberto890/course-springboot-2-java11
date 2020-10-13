package com.robertojes.projetoweb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.robertojes.projetoweb.entities.User;
import com.robertojes.projetoweb.repositories.UserRepository;
import com.robertojes.projetoweb.services.exception.ResourceNotFoundException;

// anotação pra virar componente @Component
// anotação pra virar repositorio (mais especifico) @Repository
@Service //anotação pra virar serviço (mais especifico) e no caso é um serviço mesmo
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
					//tenta dar o get se nao for lança exception
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public User insert(User obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public User update(Long id, User obj) {
		//faz uma copia mas nao é do banco de dados ainda ai da pra mexer e depois
		//fazer os negocio com o banco
		User entity = repository.getOne(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
		
	}
}
