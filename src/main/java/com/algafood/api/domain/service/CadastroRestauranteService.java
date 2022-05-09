package com.algafood.api.domain.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.algafood.api.domain.exception.EntidadeNaoEncontradaException;
import com.algafood.api.domain.model.Cozinha;
import com.algafood.api.domain.model.Restaurante;
import com.algafood.api.domain.repository.CozinhaRepository;
import com.algafood.api.domain.repository.RestauranteRepository;

@Service
public class CadastroRestauranteService {
	
	@Autowired
	private RestauranteRepository restauranteRepository;
	
	@Autowired
	private CozinhaRepository cozinhaRepository;
	
	public Restaurante salvar(Restaurante restaurante) {
		Long cozinhaId = restaurante.getCozinha().getId();
		Cozinha cozinha = cozinhaRepository.porId(cozinhaId);
		
		if (cozinha == null) {
			throw new EntidadeNaoEncontradaException(String.format("Não existe um cadastro de cozinha com código %d", cozinhaId));
		}
		restaurante.setCozinha(cozinha);
		
		return restauranteRepository.adicionar(restaurante);
	}
	
}
