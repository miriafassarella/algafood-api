package com.algafood.api.jpa;


//classe para testar a consulta cadastro cozinha
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algafood.api.AlgafoodApiApplication;

import com.algafood.api.domain.model.Estado;

import com.algafood.api.domain.repository.EstadoRepository;

public class InclusaoEstadoMain {

	public static void main(String[] args) {
		
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)//utilizado apenas para startar a aplicação por aqui
		.web(WebApplicationType.NONE)
		.run(args);//argumentos do método main
		
		EstadoRepository cozinhaRepository = applicationContext.getBean(EstadoRepository.class);
		
		Estado estado1 = new Estado();
		estado1.setNome("Ottawa");
		
		Estado estado2 = new Estado();
		estado2.setNome("Manitoba");
		
		estado1 = cozinhaRepository.adicionar(estado1);
		estado2 = cozinhaRepository.adicionar(estado2);
				
		System.out.printf("%d - %s\n", estado1.getId(), estado1.getNome());
		System.out.printf("%d - %s\n", estado2.getId(), estado2.getNome());
		
}
}