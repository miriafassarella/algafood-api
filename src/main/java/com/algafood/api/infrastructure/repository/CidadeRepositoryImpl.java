package com.algafood.api.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.algafood.api.domain.model.Cidade;

import com.algafood.api.domain.repository.CidadeRepository;


@Component
public class CidadeRepositoryImpl  implements CidadeRepository{

	@PersistenceContext
	public EntityManager manager;

	@Override
	public List<Cidade> todas(){
		return manager.createQuery("from Cidade", Cidade.class).getResultList();
									//from Cozinha especifica que quero tudo de cozinha.
									//Cozinha.class me traz uma lista de cozinha.
	}
	@Override
	public Cidade porId(Long id) {
		return manager.find(Cidade.class, id);
	}
	
	@Override
	@Transactional
	public Cidade adicionar(Cidade cidade) {
		return manager.merge(cidade);
	
	}
	@Transactional
	@Override
	public void remover(Long Id) {
		
		Cidade cidade = porId(Id);
		if (cidade == null) {
			throw new EmptyResultDataAccessException(1); //exceção do spring framework
		}
		manager.remove(cidade);
		
	}
}
