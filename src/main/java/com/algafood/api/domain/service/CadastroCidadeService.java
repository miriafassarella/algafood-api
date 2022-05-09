package com.algafood.api.domain.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.algafood.api.domain.exception.EntidadeNaoEncontradaException;
import com.algafood.api.domain.model.Cidade;
import com.algafood.api.domain.repository.CidadeRepository;

@Service
public class CadastroCidadeService {

	@Autowired
	private CidadeRepository cidadeRepository;
	
	public Cidade salvar(@RequestBody Cidade cidade) {
		 
		return cidadeRepository.adicionar(cidade);
		
	}
	
	public void excluir(Long Id) {
		try {
		cidadeRepository.remover(Id);
		}catch(EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(String.format("Não existe um cadastro de cidade com código %d", Id));
		}
	}
}
