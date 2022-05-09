package com.algafood.api.rest.controller;


import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algafood.api.domain.exception.EntidadeEmUsoException;
import com.algafood.api.domain.exception.EntidadeNaoEncontradaException;
import com.algafood.api.domain.model.Cozinha;

import com.algafood.api.domain.repository.CozinhaRepository;
import com.algafood.api.domain.service.CadastroCozinhaService;


@RestController
@RequestMapping("/cozinhas")//(value = produces= org.springframework.http.MediaType.APPLICATION_JSON_VALUE) especifica para a classe inteira
public class CozinhaController {
	
	@Autowired
	private CozinhaRepository cozinhaRepository;
	
	@Autowired
	private CadastroCozinhaService cadastroCozinha;
	
	@GetMapping//(produces= org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public List<Cozinha> listar(){
		return cozinhaRepository.todas();
	}
	
	@GetMapping("/{cozinhaId}")
	public ResponseEntity<Cozinha> buscarId(@PathVariable Long cozinhaId) {
		Cozinha cozinha = cozinhaRepository.porId(cozinhaId);
		
		
		if (cozinha != null) {
			return ResponseEntity.ok(cozinha);
		}
		//return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		return ResponseEntity.notFound().build(); //atalho
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cozinha salvar(@RequestBody Cozinha cozinha) {
		return cadastroCozinha.salvar(cozinha);
	}

	@PutMapping("/{cozinhaId}")
	public ResponseEntity<Cozinha> atualizar(@PathVariable Long cozinhaId,
			@RequestBody Cozinha cozinha){
		Cozinha cozinhaAtual = cozinhaRepository.porId(cozinhaId);
		
		if (cozinhaAtual != null) {
		//cozinhaAtual.setNome(cozinha.getNome()); funciona sem precisar enviar o id na requisicão.
		BeanUtils.copyProperties(cozinha, cozinhaAtual, "id");
		
		cadastroCozinha.salvar(cozinhaAtual);
		
		return ResponseEntity.ok(cozinhaAtual);
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{cozinhaId}")
	public ResponseEntity<Cozinha> deleteId(@PathVariable Long cozinhaId) {
		try {
		cadastroCozinha.excluir(cozinhaId);//à verificar
		
		return ResponseEntity.noContent().build();
		
		}catch (EntidadeNaoEncontradaException e) {
		
		return ResponseEntity.notFound().build();
		}catch(EntidadeEmUsoException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
		
	}
		
}
	
	
	

