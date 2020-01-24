package com.example.demo.domain;

import java.math.BigDecimal;
import java.util.List;

import com.example.demo.domain.model.Restaurante;

public interface RestauranteRepositoryQueries {

	List<Restaurante> find(String nome, 
			BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal);

}