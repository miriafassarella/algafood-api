package com.algafood.api.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


import com.algafood.api.domain.model.Estado;

import com.algafood.api.domain.repository.EstadoRepository;

@Component
public class EstadoRepositoryImpl  implements EstadoRepository{

	@PersistenceContext
	public EntityManager manager;

	@Override
	public List<Estado> todas(){
		return manager.createQuery("from Estado", Estado.class).getResultList();
									//from Cozinha especifica que quero tudo de cozinha.
									//Cozinha.class me traz uma lista de cozinha.
	}
	@Override
	public Estado porId(Long id) {
		return manager.find(Estado.class, id);
	}
	
	@Override
	@Transactional
	public Estado adicionar(Estado estado) {
		return manager.merge(estado);
	
	}
	@Transactional
	@Override
	public void remover(Long Id) {
		
		Estado estado = porId(Id);
		
		if (estado == null) {
			throw new EmptyResultDataAccessException(1); //exceção do spring framework
		}
		manager.remove(estado);
		
	}
}
