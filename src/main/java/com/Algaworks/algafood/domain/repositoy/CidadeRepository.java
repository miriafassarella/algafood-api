package com.Algaworks.algafood.domain.repositoy;

import java.util.List;

import com.Algaworks.algafood.domain.model.Cidade;


public interface CidadeRepository {

	List<Cidade> todas();
	Cidade porId(Long id);
	Cidade adicionar(Cidade cozinha);
	void remover(Cidade cidade);
}
