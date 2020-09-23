package com.robertojes.projetoweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.robertojes.projetoweb.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
