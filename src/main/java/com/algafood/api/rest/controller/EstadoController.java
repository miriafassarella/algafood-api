package com.algafood.api.rest.controller;

import java.util.List;

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
import com.algafood.api.domain.model.Estado;
import com.algafood.api.domain.repository.EstadoRepository;
import com.algafood.api.domain.service.CadastroEstadoService;

@RestController
@RequestMapping("/estados")
public class EstadoController {
	
	@Autowired
	public EstadoRepository estadoRepository;
	
	@Autowired
	public CadastroEstadoService cadastroEstado;
	
	@GetMapping
	List<Estado> listar(){
		return estadoRepository.todas();
	}

	@GetMapping("/{estadoId}")
	public ResponseEntity<Estado> buscarId(@PathVariable Long estadoId) {
		Estado estado = estadoRepository.porId(estadoId);
		
		
		if (estado != null) {
			return ResponseEntity.ok(estado);
		}
		//return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		return ResponseEntity.notFound().build(); //atalho
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Estado salvar(@RequestBody Estado estado){
		
		 return cadastroEstado.salvar(estado);
		}
	
	@PutMapping("/{estadoId}")
	public ResponseEntity<Estado> atualizar(@PathVariable Long estadoId, @RequestBody Estado estado) {
		
		Estado estadoAtual = estadoRepository.porId(estadoId);
		
		estadoAtual.setNome(estado.getNome());
		
		estadoAtual = cadastroEstado.salvar(estadoAtual);
		
		return ResponseEntity.ok(estadoAtual);
		
	}
	@DeleteMapping("/{estadoId}")
	public ResponseEntity<?> removeId(@PathVariable Long estadoId) {
		try {
		cadastroEstado.excluir(estadoId);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}catch(EntidadeNaoEncontradaException e ) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}catch(EntidadeEmUsoException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());		
			}
	}
	}
