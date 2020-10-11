package com.robertojes.projetoweb.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.robertojes.projetoweb.Services.UserService;
import com.robertojes.projetoweb.entities.User;

@RestController
@RequestMapping(value = "/users") //coloca o endereço para onde vai ficar o metodo
public class UserResource {
	
	@Autowired
	private UserService service;
	
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
							//vai receber o id do getmapping o {id}
	public ResponseEntity<User> findById(@PathVariable Long id) {
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	//quando vem json do html pro java coloca requestbody
	@PostMapping				
	public ResponseEntity<User> insert(@RequestBody User obj){
		obj = service.insert(obj);
		//nao pode ser responseentity.ok pq o mais correto é o created pq ta inserindo codigo 201 e nao 200
//		return ResponseEntity.ok().body(obj);
		
		// a responsta tem que ter o endereço do recurso que inserimos
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
}
