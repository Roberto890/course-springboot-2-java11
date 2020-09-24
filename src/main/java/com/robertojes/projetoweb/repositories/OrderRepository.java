package com.robertojes.projetoweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.robertojes.projetoweb.entities.Order;

// nao colocou @Repository aqui pq o proprio jpaRepository já é um componente do spring 
//@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
