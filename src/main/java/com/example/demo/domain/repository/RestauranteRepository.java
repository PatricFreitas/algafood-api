package com.example.demo.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.model.Restaurante;

public interface RestauranteRepository extends JpaRepository<Restaurante, Long>{

}
