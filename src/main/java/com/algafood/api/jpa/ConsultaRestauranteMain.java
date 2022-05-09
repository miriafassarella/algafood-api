package com.algafood.api.jpa;

import java.util.List;
//classe para testar a consulta cadastro cozinha
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algafood.api.AlgafoodApiApplication;

import com.algafood.api.domain.model.Restaurante;

import com.algafood.api.domain.repository.RestauranteRepository;

public class ConsultaRestauranteMain {

	public static void main(String[] args) {
		
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)//utilizado apenas para startar a aplicação por aqui
		.web(WebApplicationType.NONE)
		.run(args);//argumentos do método main
		
		RestauranteRepository restaurantes = applicationContext.getBean(RestauranteRepository.class);
		
		List<Restaurante> todosRestaurantes = restaurantes.todas();
		
		for (Restaurante restaurante : todosRestaurantes) {
			System.out.printf("%s - %f - %s\n", restaurante.getNome(), restaurante.getTaxaFrete(), restaurante.getCozinha().getNome());
		}
		
}
}