package com.algafood.api.domain.repository;

import java.util.List;


import com.algafood.api.domain.model.FormaPagamento;

public interface FormaPagamentoRepository {

	List<FormaPagamento> todas();
	FormaPagamento porId(Long id);
	FormaPagamento adicionar(FormaPagamento formaPagamento);
	void remover(FormaPagamento formaPagamento);
}
