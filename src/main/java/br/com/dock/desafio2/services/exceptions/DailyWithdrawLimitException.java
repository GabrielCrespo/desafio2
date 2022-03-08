package br.com.dock.desafio2.services.exceptions;

/**
 * Classe responsável por lidar com 
 * quaisquer exceções sobre limites de saque excedidos
 * que ocorram na camada de serviço da API
 * 
 * @author Gabriel Crespo de Souza
 * @version 1.0
 *
 */
public class DailyWithdrawLimitException extends RuntimeException {

	/** Atributo indentificador na deserialização de objetos da classe de exceção  */
	private static final long serialVersionUID = 1L;
	
	/** 
	 * 
	 * Método construtor que se comporta de acordo com a classe mãe
	 * 
	 * @param message mensagem a ser criada para representar a exceção
	 *   
	 */
	public DailyWithdrawLimitException(String message) {
		super(message);
	}

}
