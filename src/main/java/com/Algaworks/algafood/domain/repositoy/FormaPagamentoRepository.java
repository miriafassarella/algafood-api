package com.Algaworks.algafood.domain.repositoy;

import java.util.List;


import com.Algaworks.algafood.domain.model.FormaDePagamento;

public interface FormaPagamentoRepository {

	List<FormaDePagamento> todas();
	FormaDePagamento porId(Long id);
	FormaDePagamento adicionar(FormaDePagamento formaPagamento);
	void remover(FormaDePagamento formaPagamento);
}
