package com.algafood.api.jpa;


import java.math.BigDecimal;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algafood.api.AlgafoodApiApplication;

import com.algafood.api.domain.model.Restaurante;
import com.algafood.api.domain.repository.RestauranteRepository;

public class InclusaoRestauranteMain {

	public static void main(String[] args) {
		
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)//utilizado apenas para startar a aplicação por aqui
				.web(WebApplicationType.NONE)
				.run(args);//argumentos do método main
		
		RestauranteRepository restauranteRepository = applicationContext.getBean(RestauranteRepository.class);
		
		Restaurante restaurante1 = new Restaurante();
		restaurante1.setNome("La Montagne");
		
		Restaurante restaurante2 = new Restaurante();
		restaurante2.setNome("Resto da Ivone");
		
		BigDecimal big1 = new BigDecimal("2.0");
		restaurante1.setTaxaFrete(big1);
		
		BigDecimal big2 = new BigDecimal("3.0");
		restaurante2.setTaxaFrete(big2);
		
			
		restaurante1 = restauranteRepository.adicionar(restaurante1);
		restaurante2 = restauranteRepository.adicionar(restaurante2);
		
		System.out.printf("%d - %s\n", restaurante1.getId(), restaurante1.getNome());
		System.out.printf("%d - %s\n", restaurante2.getId(), restaurante2.getNome());
	}
}
