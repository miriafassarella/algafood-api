package com.algafood.api.jpa;


//classe para testar a consulta cadastro cozinha
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algafood.api.AlgafoodApiApplication;
import com.algafood.api.domain.model.Cidade;

import com.algafood.api.domain.repository.CidadeRepository;


public class InclusaoCidadeMain {

	public static void main(String[] args) {
		
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)//utilizado apenas para startar a aplicação por aqui
		.web(WebApplicationType.NONE)
		.run(args);//argumentos do método main
		
		CidadeRepository cozinhaRepository = applicationContext.getBean(CidadeRepository.class);
		
		Cidade cidade1 = new Cidade();
		cidade1.setNome("Princeville");
		
		Cidade cidade2 = new Cidade();
		cidade2.setNome("Gramby");
		
		cidade1 = cozinhaRepository.adicionar(cidade1);
		cidade2 = cozinhaRepository.adicionar(cidade2);
				
		System.out.printf("%d - %s\n", cidade1.getId(), cidade1.getNome());
		System.out.printf("%d - %s\n", cidade2.getId(), cidade2.getNome());
		
}
}