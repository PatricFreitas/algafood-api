package com.example.demo.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.exception.EntidadeNaoEncontradaException;
import com.example.demo.domain.model.Cozinha;
import com.example.demo.domain.model.Restaurante;
import com.example.demo.domain.repository.CozinhaRepository;
import com.example.demo.domain.repository.RestauranteRepository;

@Service
public class CadastroRestauranteService {
	
	private static final String MSG_RESTAURANTE_NAO_ENCONTRADO = "Não existe cadastro de restaurante com o código %d";

	@Autowired
	RestauranteRepository restauranteRepository;
	
	@Autowired
	CozinhaRepository cozinhaRepository;
	
	@Autowired
	CadastroCozinhaService cadastroCozinha;
	
	public Restaurante salvar(Restaurante restaurante) {
		Long cozinhaId = restaurante.getCozinha().getId();
		
		Cozinha cozinha = cadastroCozinha.buscarOuFalhar(cozinhaId);
						
		restaurante.setCozinha(cozinha);
		
		return restauranteRepository.save(restaurante);
	}
	
	public Restaurante buscarOuFalhar(Long restauranteId) {
		return restauranteRepository.findById(restauranteId).orElseThrow(
				()->new EntidadeNaoEncontradaException(String.format(MSG_RESTAURANTE_NAO_ENCONTRADO, restauranteId)));
	}

}
