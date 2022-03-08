package br.com.dock.desafio2.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.dock.desafio2.dto.ContaDTO;
import br.com.dock.desafio2.enums.TipoConta;


/**
 * Classe responsável pelo mapeamento objeto-relacional da entidade Conta.
 * 
 * @author Gabriel Crespo de Souza
 * @version 1.0
 *
 */

@Entity
@Table(name = "contas")
public class Conta implements Serializable {

	/** Atributo indentificador na deserialização de objetos da classe Conta  */
	private static final long serialVersionUID = 1L;

	/** Atributo indentificador de uma instância da classe Conta  */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idConta;

	/** Atributo indentificador da relação uma instância da classe Conta com a classe Pessoa  */
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "idPessoa", referencedColumnName = "idPessoa")
	private Pessoa idPessoa;

	/** Atributo que representa o saldo de uma instância da classe Conta  */
	@Column(precision = 10, scale = 2)
	private BigDecimal saldo;

	/** Atributo que representa o limite de saque de uma instância da classe Conta  */
	@Column(precision = 10, scale = 2)
	private BigDecimal limiteSaqueDiario;
	
	/** Atributo que representa o estado de uma instância da classe Conta  */
	@Column(columnDefinition = "boolean default false")
	private Boolean flagAtivo;
	
	/** Atributo que representa o tipo de uma instância da classe Conta
	 * 	pessoa física ou pessoa jurídica
	 */
	private TipoConta tipoConta;
	
	/** Atributo que representa data de criação de uma instância da classe Conta  */
	private Date dataCriacao;

	/** Atributo que representa a lista de transações que uma instâcia da classe Conta possui */
	@OneToMany(mappedBy = "idTransacao")
	private List<Transacao> transacoes = new ArrayList<Transacao>();

	/** Construtor sem parâmetros */
	public Conta() {

	}

	/** Construtor com parâmetros
	 * 
	 * @param idConta o identificador da instância
	 * @param idPessoa o identificador da pessoa relacionada à conta
	 * @param saldo saldo relativo à instância 
	 * @param limiteSaqueDiario limite de saque diário relativo à instância
	 * @param flagAtivo status relativo à instância
	 * @param tipoConta tipo de conta relativo à instância
	 * @param dataCriacao data de criação relativo à instância
	 * 
	 */
	public Conta(Long idConta, Pessoa idPessoa, BigDecimal saldo, BigDecimal limiteSaqueDiario, Boolean flagAtivo,
			TipoConta tipoConta, Date dataCriacao) {
		this.idConta = idConta;
		this.idPessoa = idPessoa;
		this.saldo = saldo;
		this.limiteSaqueDiario = limiteSaqueDiario;
		this.flagAtivo = flagAtivo;
		this.tipoConta = tipoConta;
		this.dataCriacao = dataCriacao;
	}
	
	/** Construtor com parâmetros
	 * 
	 * @param entity objeto responsável pela transeferência de dados
	 * 
	 */
	public Conta(ContaDTO entity) {
		this.idConta= entity.getId();
		this.idPessoa = entity.getPessoa();
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
	public Long getIdConta() {
		return idConta;
	}

	/** 
	 * Método responsável por retornar o id da pessoal relacionada 
	 * à instância 
	 * 
	 * @return o id da instância da pessoa em questão
	 */
	public Pessoa getIdPessoa() {
		return idPessoa;
	}
	
	/** 
	 * Método responsável por atribuir o id da pessoal relacionada à instância 
	 * 
	 * @param idPessoa identificador da pessoa a ser atribuido à instância
	 */
	public void setIdPessoa(Pessoa idPessoa) {
		this.idPessoa = idPessoa;
	}

	/** 
	 * Método responsável por retornar o saldo da instância 
	 * 
	 * @return o saldo da instância em questão
	 */
	public BigDecimal getSaldo() {
		return saldo;
	}

	/** 
	 * Método responsável por atribuir o saldo da instância 
	 * 
	 * @param saldo valor de saldo a ser atribuido à instância
	 */
	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	/** 
	 * Método responsável por retornar o limite de saque diário da instância 
	 * 
	 * @return o limite de saque diário da instância em questão
	 */
	public BigDecimal getLimiteSaqueDiario() {
		return limiteSaqueDiario;
	}

	/** 
	 * Método responsável por atribuir o saldo da instância 
	 * 
	 * @param limiteSaqueDiario valor de saldo a ser atribuido à instância
	 */
	public void setLimiteSaqueDiario(BigDecimal limiteSaqueDiario) {
		this.limiteSaqueDiario = limiteSaqueDiario;
	}

	/** 
	 * Método responsável por retornar o status da instância 
	 * 
	 * @return o status da instância em questão
	 */
	public Boolean getFlagAtivo() {
		return flagAtivo;
	}

	/** 
	 * Método responsável por atribuir status da instância 
	 * 
	 * @param flagAtivo valor de saldo a ser atribuido à instância
	 */
	public void setFlagAtivo(Boolean flagAtivo) {
		this.flagAtivo = flagAtivo;
	}

	/** 
	 * Método responsável por retornar o tipo de conta da instância 
	 * 
	 * @return tipo de conta da instância em questão
	 */
	public TipoConta getTipoConta() {
		return tipoConta;
	}

	/** 
	 * Método responsável por atribuir status da instância 
	 * 
	 * @param tipoConta valor de saldo a ser atribuido à instância
	 */
	public void setTipoConta(TipoConta tipoConta) {
		this.tipoConta = tipoConta;
	}

	/** 
	 * Método responsável por retornar a data de criação da instância 
	 * 
	 * @return a data de criação da instância em questão
	 */
	public Date getDataCriacao() {
		return dataCriacao;
	}

	/** 
	 * Método responsável por atribuir a data de criação da instância 
	 * 
	 * @param dataCriacao a data de criação a ser atribuida à instância
	 */
	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	/** 
	 * Método responsável por retornar a lista de transações da instância 
	 * 
	 * @return a lista de transações da instância em questão
	 */
	public List<Transacao> getTransacoes() {
		return transacoes;
	}


	/** 
	 * Método responsável por formatar a apresentação de uma instância 
	 * 
	 * @return a instância formatada de modo legível
	 */
	@Override
	public String toString() {
		return "Conta [idConta=" + idConta + ", idPessoa=" + idPessoa + ", saldo=" + saldo + ", limiteSaqueDiario="
				+ limiteSaqueDiario + ", flagAtivo=" + flagAtivo + ", tipoConta=" + tipoConta + ", dataCriacao="
				+ dataCriacao + ", transacoes=" + transacoes + "]";
	}

	/** 
	 * Método responsável por gerar o código que representa o índice
	 * de uma estrutura de dados baseada em cálculos hash para salvar
	 * a instância. 
	 * 
	 * @return o código hash
	 */
	@Override
	public int hashCode() {
		return Objects.hash(idConta);
	}

	/** 
	 * Método responsável por validar a igualdade entre dois objetos do mesmo tipo
	 * 
	 * @return se dois objetos são ou não iguais
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conta other = (Conta) obj;
		return Objects.equals(idConta, other.idConta);
	}
}
