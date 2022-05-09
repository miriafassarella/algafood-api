package com.algafood.api.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


import com.algafood.api.domain.model.Permissao;

import com.algafood.api.domain.repository.PermissaoRepository;

@Component
public class PermissaoRepositoryImpl  implements PermissaoRepository{

	@PersistenceContext
	public EntityManager manager;

	@Override
	public List<Permissao> todas(){
		return manager.createQuery("from Permissao", Permissao.class).getResultList();
									//from Cozinha especifica que quero tudo de cozinha.
									//Cozinha.class me traz uma lista de cozinha.
	}
	@Override
	public Permissao porId(Long id) {
		return manager.find(Permissao.class, id);
	}
	
	@Override
	@Transactional
	public Permissao adicionar(Permissao permissao) {
		return manager.merge(permissao);
	
	}
	@Transactional
	@Override
	public void remover(Permissao permissao) {
		
		permissao = porId(permissao.getId());
		manager.remove(permissao);
		
	}
}
