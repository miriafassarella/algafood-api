package com.Algaworks.algafood.domain.repositoy;

import java.util.List;

import com.Algaworks.algafood.domain.model.Permissao;

public interface PermissaoRepository {

	List<Permissao> todas();
	Permissao porId(Long id);
	Permissao adicionar(Permissao permissao);
	void remover(Permissao permissao);
}
