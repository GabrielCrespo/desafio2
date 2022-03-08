package br.com.dock.desafio2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Classe responsável pelo início da aplicação SpringBoot
 * 
 * @author Gabriel Crespo de Souza
 * @version 1.0
 *
 */

@EnableWebMvc
@SpringBootApplication
public class Desafio2Application {

	/**
	 * Método resposável por ser a porta de entrada
	 * da aplicação
	 *
	 * @param args argumentos da função main
	 */
	public static void main(String[] args) {
		SpringApplication.run(Desafio2Application.class, args);
	}

}
