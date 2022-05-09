package com.algafood.api.jpa;

import java.util.List;
//classe para testar a consulta cadastro cozinha
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algafood.api.AlgafoodApiApplication;
import com.algafood.api.domain.model.Cozinha;
import com.algafood.api.domain.repository.CozinhaRepository;

public class ConsultaCozinhaMain {

	public static void main(String[] args) {
		
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)//utilizado apenas para startar a aplicação por aqui
		.web(WebApplicationType.NONE)
		.run(args);//argumentos do método main
		
		CozinhaRepository cozinhas = applicationContext.getBean(CozinhaRepository.class);
		
		List<Cozinha> todasCozinhas = cozinhas.todas();
		
		for (Cozinha cozinha : todasCozinhas) {
			System.out.println(cozinha.getNome());
		}
		
}
}