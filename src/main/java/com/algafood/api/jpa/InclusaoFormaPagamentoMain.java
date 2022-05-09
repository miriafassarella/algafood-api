package com.algafood.api.jpa;


//classe para testar a consulta cadastro cozinha
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algafood.api.AlgafoodApiApplication;

import com.algafood.api.domain.model.FormaPagamento;

import com.algafood.api.domain.repository.FormaPagamentoRepository;

public class InclusaoFormaPagamentoMain {

	public static void main(String[] args) {
		
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)//utilizado apenas para startar a aplicação por aqui
		.web(WebApplicationType.NONE)
		.run(args);//argumentos do método main
		
		FormaPagamentoRepository formaPagamentoRepository = applicationContext.getBean(FormaPagamentoRepository.class);
		
		FormaPagamento formaPagamento1 = new FormaPagamento();
		formaPagamento1.setDescricao("Débito");
		
		FormaPagamento formaPagamento2 = new FormaPagamento();
		formaPagamento2.setDescricao("Dinheiro");
		
		formaPagamento1 = formaPagamentoRepository.adicionar(formaPagamento1);
		formaPagamento2 = formaPagamentoRepository.adicionar(formaPagamento2);
				
		System.out.printf("%d - %s\n", formaPagamento1.getId(), formaPagamento1.getDescricao());
		System.out.printf("%d - %s\n", formaPagamento2.getId(), formaPagamento2.getDescricao());
		
}
}