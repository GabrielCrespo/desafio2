package br.com.dock.desafio2.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import br.com.dock.desafio2.entities.Conta;
import br.com.dock.desafio2.entities.Pessoa;
import br.com.dock.desafio2.enums.TipoConta;

/**
 * Classe responsável pelo definição do modelo de
 * transferência de contas
 * 
 * @author Gabriel Crespo de Souza
 * @version 1.0
 *
 */
public class ContaDTO implements Serializable {
	
	/** Atributo indentificador na deserialização de objetos da classe ContaDTO  */
	private static final long serialVersionUID = 1L;
	
	/** Atributo indentificador de uma instância da classe ContaDTO  */
	private Long id;
	
	/** Atributo indentificador da relação uma instância da classe ContaDTO com a classe Pessoa  */
	private Pessoa pessoa;
	
	/** Atributo que representa o saldo de uma instância da classe ContaDTO  */
	private BigDecimal saldo;
	
	/** Atributo que representa o limite de saque de uma instância da classe Conta  */
	private BigDecimal limiteSaqueDiario;
	
	/** Atributo que representa o estado de uma instância da classe Conta  */
	private Boolean flagAtivo;
	
	/** Atributo que representa o tipo de uma instância da classe Conta
	 * 	pessoa física ou pessoa jurídica
	 */
	private TipoConta tipoConta;
	
	/** Atributo que representa data de criação de uma instância da classe Conta  */
	private Date dataCriacao;
	
	/** Construtor sem parâmetros */
	public ContaDTO() {
		
	}

	/** Construtor com parâmetros
	 * 
	 * @param id o identificador da instância
	 * @param pessoa o identificador da pessoa relacionada à conta
	 * @param saldo saldo relativo à instância 
	 * @param limiteSaqueDiario limite de saque diário relativo à instância
	 * @param flagAtivo status relativo à instância
	 * @param tipoConta tipo de conta relativo à instância
	 * @param dataCriacao data de criação relativo à instância
	 * 
	 */
	public ContaDTO(Long id, Pessoa pessoa, BigDecimal saldo, BigDecimal limiteSaqueDiario, Boolean flagAtivo,
			TipoConta tipoConta, Date dataCriacao) {
		this.id= id;
		this.pessoa = pessoa;
		this.saldo = saldo;
		this.limiteSaqueDiario = limiteSaqueDiario;
		this.flagAtivo = flagAtivo;
		this.tipoConta = tipoConta;
		this.dataCriacao = dataCriacao;
	}
	
	/** Construtor com parâmetros
	 * 
	 * @param entity objeto do tipo Conta
	 * 
	 */
	public ContaDTO(Conta entity) {
		this.id= entity.getIdConta();
		this.pessoa = entity.getIdPessoa();
		this.saldo = entity.getSaldo();
		this.limiteSaqueDiario = entity.getLimiteSaqueDiario();
		this.flagAtivo = entity.getFlagAtivo();
		this.tipoConta = entity.getTipoConta();
		this.dataCriacao = entity.getDataCriacao();
	}
	

	/** 
	 * Método responsável por retornar o id da instância 
	 * 
	 * @return o id da instância em questão
	 */
	public Long getId() {
		return id;
	}

	/** 
	 * Método responsável por atribuir o id da instância 
	 * 
	 * @param id identificador da instância
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/** 
	 * Método responsável por retornar a pessoa relacionada 
	 * à instância 
	 * 
	 * @return a instância da pessoa em questão
	 */
	public Pessoa getPessoa() {
		return pessoa;
	}

	/** 
	 * Método responsável por atribuir a pessoa relacionada à instância
	 * 
	 * @param pessoa pessoa relacionada à instância
	 */
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	/** 
	 * Método responsável por retornar o saldo
	 * da instância 
	 * 
	 * @return o saldo da instância
	 */
	public BigDecimal getSaldo() {
		return saldo;
	}

	/** 
	 * Método responsável por atribuir o saldo da instância
	 * 
	 * @param saldo o saldo da instância
	 */
	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	/** 
	 * Método responsável por retornar o limite de saque 
	 * diário da instância 
	 * 
	 * @return o limite de saque diário da instância
	 */
	public BigDecimal getLimiteSaqueDiario() {
		return limiteSaqueDiario;
	}

	/** 
	 * Método responsável por atribuir o limite de saque 
	 * diário
	 * 
	 * @param limiteSaqueDiario limite de saque diário
	 */
	public void setLimiteSaqueDiario(BigDecimal limiteSaqueDiario) {
		this.limiteSaqueDiario = limiteSaqueDiario;
	}

	/** 
	 * Método responsável por retornar status
	 * da instância 
	 * 
	 * @return o status da instância
	 */
	public Boolean getFlagAtivo() {
		return flagAtivo;
	}

	/** 
	 * Método responsável por atribuir status 
	 * da instância
	 * 
	 * @param flagAtivo status da instância
	 */
	public void setFlagAtivo(Boolean flagAtivo) {
		this.flagAtivo = flagAtivo;
	}

	/** 
	 * Método responsável por retornar o tipo
	 * de conta da instância
	 * 
	 * @return o tipo de conta da instância
	 */
	public TipoConta getTipoConta() {
		return tipoConta;
	}

	/** 
	 * Método responsável por atribuir o tipo 
	 * de conta da instância
	 * 
	 * @param tipoConta o tipo de conta da instância
	 */
	public void setTipoConta(TipoConta tipoConta) {
		this.tipoConta = tipoConta;
	}

	/** 
	 * Método responsável por retornar a data
	 * de criação da instância
	 * 
	 * @return a data de criação da instância
	 */
	public Date getDataCriacao() {
		return dataCriacao;
	}

	/** 
	 * Método responsável por atribuir a data 
	 * de criação da conta
	 * 
	 * @param dataCriacao a data de criação da conta
	 */
	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}


}
