package com.algafood.api.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.algafood.api.domain.exception.EntidadeEmUsoException;
import com.algafood.api.domain.exception.EntidadeNaoEncontradaException;
import com.algafood.api.domain.model.Estado;
import com.algafood.api.domain.repository.EstadoRepository;

@Service
public class CadastroEstadoService {
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	public Estado salvar(Estado estado) {
		
		return estadoRepository.adicionar(estado);
	}
	
	public void excluir(Long estadoId) {
		
		
		try {
			
		estadoRepository.remover(estadoId);
		}catch(EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(String.format("Não existe um cadastro de cozinha com código %d", estadoId));
			
		}catch(DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(String.format("Estado de id %d não pode ser removido, pois está em uso", estadoId));
		}
	}

}
