package com.algafood.api.jpa;


//classe para testar a consulta cadastro cozinha
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algafood.api.AlgafoodApiApplication;

import com.algafood.api.domain.model.Permissao;

import com.algafood.api.domain.repository.PermissaoRepository;

public class InclusaoPermissaoMain {

	public static void main(String[] args) {
		
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)//utilizado apenas para startar a aplicação por aqui
		.web(WebApplicationType.NONE)
		.run(args);//argumentos do método main
		
		PermissaoRepository permissaoRepository = applicationContext.getBean(PermissaoRepository.class);
		
		Permissao permissao1 = new Permissao();
		permissao1.setNome("Em Análise");
		permissao1.setDescricao("Dinheiro");
		
		Permissao permissao2 = new Permissao();
		permissao2.setNome("Autorizacão Gerente");
		permissao2.setDescricao("Pix");
		
		permissao1 = permissaoRepository.adicionar(permissao1);
		permissao2 = permissaoRepository.adicionar(permissao2);
				
		System.out.printf("%d - %s\n", permissao1.getId(), permissao1.getNome());
		System.out.printf("%d - %s\n", permissao2.getId(), permissao2.getNome());
		
}
}