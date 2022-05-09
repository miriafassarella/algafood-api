package com.algafood.api.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
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

import com.algafood.api.domain.exception.EntidadeNaoEncontradaException;
import com.algafood.api.domain.model.Cidade;

import com.algafood.api.domain.repository.CidadeRepository;
import com.algafood.api.domain.service.CadastroCidadeService;


@RestController
@RequestMapping("/cidades")
public class CidadeController {

	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private CadastroCidadeService cadastroCidade;
	
	@GetMapping
	public List<Cidade> listar(){
		return cidadeRepository.todas();		
	}
	
	@GetMapping("/{cidadeId}")
	public ResponseEntity<Cidade> buscarId(@PathVariable Long cidadeId){
		
		Cidade cidade = cidadeRepository.porId(cidadeId);
		if(cidade != null) {
		return ResponseEntity.ok(cidade);
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cidade salvar(@RequestBody Cidade cidade) {
		
		return cadastroCidade.salvar(cidade);
		
	}
	
	@PutMapping("/{cidadeId}")
	public ResponseEntity<Cidade> excluir(@PathVariable Long cidadeId, @RequestBody Cidade cidade){
		Cidade cidadeAtual = cidadeRepository.porId(cidadeId);
		if (cidadeAtual != null) {
		cidadeAtual.setNome(cidade.getNome());		
		cadastroCidade.salvar(cidadeAtual);
		return ResponseEntity.ok(cidadeAtual);
		}
		
		return ResponseEntity.notFound().build();
		
	}
	
	@DeleteMapping("/{cidadeId}")
	public ResponseEntity<?> excluir (@PathVariable Long cidadeId){
	
		try {
			cadastroCidade.excluir(cidadeId);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
		
		
	}
	
}
