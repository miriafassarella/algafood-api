package com.algafood.api.domain.repository;

import java.util.List;

import com.algafood.api.domain.model.Cidade;


public interface CidadeRepository {

	List<Cidade> todas();
	Cidade porId(Long id);
	Cidade adicionar(Cidade cidade);
	void remover(Long Id);
}
