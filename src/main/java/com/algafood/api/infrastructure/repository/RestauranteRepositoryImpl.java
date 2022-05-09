package com.algafood.api.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


import com.algafood.api.domain.model.Restaurante;
import com.algafood.api.domain.repository.RestauranteRepository;

@Component
public class RestauranteRepositoryImpl implements RestauranteRepository {
	
	@PersistenceContext
	public EntityManager manager;

	@Override
	public List<Restaurante> todas(){
		return manager.createQuery("from Restaurante", Restaurante.class).getResultList();
									//from Cozinha especifica que quero tudo de cozinha.
									//Cozinha.class me traz uma lista de cozinha.
	}
	@Override
	public Restaurante porId(Long id) {
		return manager.find(Restaurante.class, id);
	}
	
	@Override
	@Transactional
	public Restaurante adicionar(Restaurante restaurante) {
		return manager.merge(restaurante);
	
	}
	@Transactional
	@Override
	public void remover(Restaurante restaurante) {
		
		restaurante = porId(restaurante.getId());
		manager.remove(restaurante);
		
	}

}
