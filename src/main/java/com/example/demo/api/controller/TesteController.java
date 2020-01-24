package com.example.demo.api.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.model.Restaurante;
import com.example.demo.domain.repository.CozinhaRepository;
import com.example.demo.domain.repository.RestauranteRepository;

@RestController
@RequestMapping("/teste")
public class TesteController {
	
	@Autowired
	private CozinhaRepository cozinhaRepository;
	
	@Autowired
	private RestauranteRepository restauranteRepository;
	
	
	
	@GetMapping("/restaurantes/por-nome")
	public List<Restaurante> restaurantesPorNomeECozinha(String nome, Long cozinhaId){
		return this.restauranteRepository.consultarPorNome(nome, cozinhaId);
	}
	
	@GetMapping("/restaurantes/por-nome-e-taxaFrete")
	public List<Restaurante> restaurantesPorNomeETaxaFrete(String nome, BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal){
		return this.restauranteRepository.find(nome, taxaFreteInicial, taxaFreteFinal);
	}
	

}
