package com.Algaworks.algafood.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;


import com.Algaworks.algafood.domain.model.FormaDePagamento;
import com.Algaworks.algafood.domain.repositoy.FormaPagamentoRepository;

public class FormaPagamentoImpl implements FormaPagamentoRepository {

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<FormaDePagamento> todas(){
		return manager.createQuery("from FormaDePagamento", FormaDePagamento.class).getResultList();
	}
	@Override
	public FormaDePagamento porId(Long id) {
		return manager.find(FormaDePagamento.class, id);
	}
	
	@Transactional
	@Override
	public FormaDePagamento adicionar(FormaDePagamento formaDePagamento) {
		return manager.merge(formaDePagamento);
		
	}
	@Transactional
	@Override
	public void remover(FormaDePagamento formaDePagamento) {
		formaDePagamento = porId(formaDePagamento.getId());
		manager.remove(formaDePagamento);
	}
}
