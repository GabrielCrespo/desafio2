package br.com.dock.desafio2.resources.exceptions;

import java.io.Serializable;
import java.time.Instant;

/**
 * Classe responsável por representar a mensagem padrão
 * para as exceções
 * 
 * @author Gabriel Crespo de Souza
 * @version 1.0
 *
 */
public class StandardError implements Serializable {

	/** 
	 * 	Atributo indentificador na deserialização de objetos da classe 
	 * 	padrão de exceções  
	 */
	private static final long serialVersionUID = 1L;
	
	/** Atributo que representa o momento em que a exceção ocorreu  */
	private Instant timestamp;
	
	/** Atributo que representa o status da requisição */
	private Integer status;
	
	/** Atributo que representa o erro ocorrido  */
	private String error;
	
	/** Atributo que representa a mensagem padrão sobre a exceção ocorrida  */
	private String message;
	
	/** Atributo que representa a rota em que a exceção ocorreu  */
	private String path;
	
	/** Construtor padrão  */
	public StandardError() {
		
	}

	/** 
	 * Método responsável por retornar instante
	 * em que ocorreu a exceção
	 * 
	 * @return o instante em que ocorreu a exceção
	 */
	public Instant getTimestamp() {
		return timestamp;
	}

	/** 
	 * Método responsável por atribuir o instante
	 * em que ocorreu a transação
	 * 
	 * @param timestamp instante em que ocorreu a transação
	 */
	public void setTimestamp(Instant timestamp) {
		this.timestamp = timestamp;
	}

	/** 
	 * Método responsável por retornar o status
	 * da requisição
	 * 
	 * @return o status da requisição
	 */
	public Integer getStatus() {
		return status;
	}

	/** 
	 * Método responsável por atribuir o status da requisição
	 * 
	 * @param status status da requisições
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/** 
	 * Método responsável por retornar o erro
	 * causador da exceção
	 * 
	 * @return o erro causador da exceção
	 */
	public String getError() {
		return error;
	}

	/** 
	 * Método responsável por atribuir o erro
	 * causador da exceção
	 * 
	 * @param error erro causador da exceção
	 */
	public void setError(String error) {
		this.error = error;
	}

	/** 
	 * Método responsável por retornar a mensagem
	 * que representa a causa do problema
	 * 
	 * @return a mensagem que representa a causa do problema
	 */
	public String getMessage() {
		return message;
	}

	/** 
	 * Método responsável por atribuir a mensagem
	 * que representa a causa do problema
	 * 
	 * @param message mensagem que representa a causa do problema
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/** 
	 * Método responsável por retornar a rota
	 * chamada durante a ocorrência da exceção
	 * 
	 * @return a rota chamada durante a ocorrência da exceção
	 */
	public String getPath() {
		return path;
	}

	/** 
	 * Método responsável por atribuir a rota
	 * chamada durante a ocorrência da exceção
	 * 
	 * @param path rota chamada durante a ocorrência da exceção
	 */
	public void setPath(String path) {
		this.path = path;
	}

}
