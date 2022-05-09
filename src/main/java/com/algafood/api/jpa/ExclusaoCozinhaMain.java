package com.algafood.api.jpa;


//classe para testar a consulta cadastro cozinha
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algafood.api.AlgafoodApiApplication;


import com.algafood.api.domain.service.CadastroCozinhaService;


public class ExclusaoCozinhaMain {

	public static void main(String[] args) {
		
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)//utilizado apenas para startar a aplicação por aqui
		.web(WebApplicationType.NONE)
		.run(args);//argumentos do método main
		applicationContext.getBean(CadastroCozinhaService.class);
		
		CadastroCozinhaService cozinhas = new CadastroCozinhaService();
		
		cozinhas.excluir(2L);
		
		
		
		
		
		
		
		
}
}