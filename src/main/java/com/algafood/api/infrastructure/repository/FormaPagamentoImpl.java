package com.algafood.api.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


import com.algafood.api.domain.model.FormaPagamento;

import com.algafood.api.domain.repository.FormaPagamentoRepository;

@Component
public class FormaPagamentoImpl  implements FormaPagamentoRepository{

	@PersistenceContext
	public EntityManager manager;

	@Override
	public List<FormaPagamento> todas(){
		return manager.createQuery("from FormaPagamento", FormaPagamento.class).getResultList();
									//from Cozinha especifica que quero tudo de cozinha.
									//Cozinha.class me traz uma lista de cozinha.
	}
	@Override
	public FormaPagamento porId(Long id) {
		return manager.find(FormaPagamento.class, id);
	}
	
	@Override
	@Transactional
	public FormaPagamento adicionar(FormaPagamento formaPagamento) {
		return manager.merge(formaPagamento);
	
	}
	@Transactional
	@Override
	public void remover(FormaPagamento formaPagamento) {
		
		formaPagamento = porId(formaPagamento.getId());
		manager.remove(formaPagamento);
		
	}
}
