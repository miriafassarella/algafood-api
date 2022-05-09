package com.algafood.api.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.algafood.api.domain.model.Cozinha;
import com.algafood.api.domain.repository.CozinhaRepository;

@Component
public class CozinhaRepositoryImpl  implements CozinhaRepository{

	@PersistenceContext
	public EntityManager manager;

	@Override
	public List<Cozinha> todas(){
		return manager.createQuery("from Cozinha", Cozinha.class).getResultList();
									//from Cozinha especifica que quero tudo de cozinha.
									//Cozinha.class me traz uma lista de cozinha.
	}
	@Override
	public Cozinha porId(Long id) {
		return manager.find(Cozinha.class, id);
	}
	
	@Override
	@Transactional
	public Cozinha adicionar(Cozinha cozinha) {
		return manager.merge(cozinha);
	
	}
	@Transactional
	@Override
	public void remover(Long id) {
		Cozinha cozinha = porId(id);
		
		if (cozinha == null) {
			throw new EmptyResultDataAccessException(1); //exceção do spring framework
		}
		
		manager.remove(cozinha);
		
	}
}
