package br.com.dock.desafio2.dto;

import java.math.BigDecimal;
import java.util.Date;

import br.com.dock.desafio2.entities.Transacao;

/**
 * Classe responsável pelo definição do modelo de
 * transferência de transações
 * 
 * @author Gabriel Crespo de Souza
 * @version 1.0
 *
 */
public class TransacaoDTO {
	
	/** Atributo indentificador na deserialização de objetos da classe TransacaoDTO  */
	private Long idTransacao;
	
	/** Atributo que representa o valor de uma instância da classe TransacaoDTO  */
	private BigDecimal valor;
	
	/** Atributo que representa a data de uma instância da classe TransacaoDTO  */
	private Date data;
	
	/** Atributo que representa a descrição de uma instância da classe TransacaoDTO  */
	private String descricao;
	
	/** Construtor sem parâmetros */
	public TransacaoDTO() {
		
	}

	/** 
	 * Construtor com parâmetros 
	 * 
	 * @param idTransacao o identificador da instância
	 * @param valor valor relativo à instância
	 * @param data data relativa à instância
	 * @param descricao descrição relativa à instância
	 * 
	 * 
	 * */
	public TransacaoDTO(Long idTransacao, BigDecimal valor, Date data, String descricao) {
		this.idTransacao = idTransacao;
		this.valor = valor;
		this.data = data;
		this.descricao = descricao;
	}
	
	/** 
	 * Construtor com parâmetros 
	 * 
	 * @param entity objeto do tipo transação
	 * 
	 * */
	public TransacaoDTO(Transacao entity) {
		this.idTransacao = entity.getIdTransacao();
		this.valor = entity.getValor();
		this.data = entity.getData();
		this.descricao = entity.getDescricao();
	}

	
	/** 
	 * Método responsável por retornar o id da instância 
	 * 
	 * @return o id da instância em questão
	 */
	public Long getIdTransacao() {
		return idTransacao;
	}

	/** 
	 * Método responsável por atribuir o id da instância 
	 * 
	 * @param idTransacao identificador da instância
	 */
	public void setIdTransacao(Long idTransacao) {
		this.idTransacao = idTransacao;
	}

	/** 
	 * Método responsável por retornar o valor da instância 
	 * 
	 * @return o valor da instância em questão
	 */
	public BigDecimal getValor() {
		return valor;
	}

	/** 
	 * Método responsável por atribuir o valor da instância 
	 * 
	 * @param valor valor monetário da instância
	 */
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	/** 
	 * Método responsável por retornar a data da instância 
	 * 
	 * @return a data da instância em questão
	 */
	public Date getData() {
		return data;
	}

	/** 
	 * Método responsável por atribuir a data da instância 
	 * 
	 * @param data data da instância
	 */
	public void setData(Date data) {
		this.data = data;
	}

	/** 
	 * Método responsável por retornar a descrição da instância 
	 * 
	 * @return a descrição da instância em questão
	 */
	public String getDescricao() {
		return descricao;
	}

	/** 
	 * Método responsável por atribuir a descrição da instância 
	 * 
	 * @param descricao descrição da instância
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	

}
