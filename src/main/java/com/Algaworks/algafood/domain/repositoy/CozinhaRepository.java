package com.Algaworks.algafood.domain.repositoy;

import java.util.List;

import com.Algaworks.algafood.domain.model.Cozinha;

public interface CozinhaRepository {

	
	List<Cozinha> todas();
	Cozinha porId(Long id);
	Cozinha adicionar(Cozinha cozinha);
	void remover(Cozinha cozinha);
	
}
