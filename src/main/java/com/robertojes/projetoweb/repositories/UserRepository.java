package com.robertojes.projetoweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.robertojes.projetoweb.entities.User;

// nao colocou @Repository aqui pq o proprio jpaRepository já é um componente do spring 
//@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
