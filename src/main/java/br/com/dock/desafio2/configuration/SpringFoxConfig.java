package br.com.dock.desafio2.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
/**
 * Classe responsável configurar as informações de documentação
 * utilizando o swagger-ui
 * 
 * @author Gabriel Crespo de Souza
 * @version 1.0
 *
 */

@Configuration
public class SpringFoxConfig {

	/**
	 * Método responsável por aplicar as configarações
	 * de utilização do Swagger na API
	 * 
	 * @return um construtor de interface do Swagger
	 * 
	 */
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("br.com.dock.desafio2.resources"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(apiInfo());
	}
	
	/**
	 * Método responsável por configurar as 
	 * meta-informações do projeto
	 * 
	 * @return um construtor de meta-informações do projeto
	 * 
	 */
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("Rest API de gestão de contas")
				.description("Desafio Dock Tech de Seleção")
				.version("1.0.0")
				.build();
	}
}
