package com.Algaworks.algafood.domain.repositoy;

import java.util.List;

import com.Algaworks.algafood.domain.model.Restaurante;

public interface RestauranteRepository {

	List<Restaurante> todas();
	Restaurante porId(Long id);
	Restaurante adicionar(Restaurante restaurante);
	void remover(Restaurante restaurante);
}
