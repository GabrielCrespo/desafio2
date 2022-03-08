package br.com.dock.desafio2.dto;

import java.math.BigDecimal;

/**
 * Classe responsável pelo definição do modelo de
 * transferência de valores monetários
 * 
 * @author Gabriel Crespo de Souza
 * @version 1.0
 *
 */
public class ValorDTO {

	/** Atributo responsável por representar o valor monetário atuante nas transações  */
	private BigDecimal valor;
	
	/** Construtor sem parâmetros */
	public ValorDTO() {
	}

	/** 
	 * Construtor com argumentos  
	 * 
	 * @param valor valor monetário atuante nas transações
	 */
	public ValorDTO(BigDecimal valor) {
		this.valor = valor;
	}

	/** 
	 * Método responsável por retornar o valor monetário
	 * 
	 * @return o valor monetário
	 */
	public BigDecimal getValor() {
		return valor;
	}

	/** 
	 * Método responsável por atribuir o valor monetário
	 * 
	 * @param valor o valor monetário
	 */
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
}
