package com.example.demo.domain.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.domain.model.Restaurante;

public interface RestauranteRepository 
	extends JpaRepository<Restaurante, Long>, RestauranteRepositoryQueries{
	
	List<Restaurante> findByTaxaFreteBetween (BigDecimal taxaInicial, BigDecimal taxaFinal);
	
//	@Query("from Restaurante where nome like %:nome% and  cozinha.id = :id")
	List<Restaurante> consultarPorNome(String nome, @Param("id") Long cozinhaID);
	
	

}
