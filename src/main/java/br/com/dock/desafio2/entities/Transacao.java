package br.com.dock.desafio2.entities;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Classe responsável pelo mapeamento objeto-relacional da entidade Transação.
 * 
 * @author Gabriel Crespo de Souza
 * @version 1.0
 *
 */

@Entity
@Table(name = "transacoes")
public class Transacao {
	
	/** Atributo indentificador na deserialização de objetos da classe Transação  */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTransacao;
	
	/** Atributo indentificador de uma instância da classe Conta relacionada
	 *  à uma instância da classe Transação 
	 */
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "idConta", referencedColumnName = "idConta")
	private Conta conta;
	
	/** Atributo que representa o valor de uma instância da classe Transação  */
	@Column(precision = 10, scale = 2, nullable = false)
	private BigDecimal valor;
	
	/** Atributo que representa a data de uma instância da classe Transação  */
	private Date data;
	
	/** Atributo que representa a descrição de uma instância da classe Transação  */
	private String descricao;
	
	/** Construtor sem parâmetros */
	public Transacao() {
	}

	/** Construtor com parâmetros
	 * 
	 * @param idTransacao o identificador da instância
	 * @param conta o identificador da conta relacionada à transação
	 * @param valor valor relativo à instância 
	 * @param data data relativo à instância
	 * @param descricao descrição relativo à instância
	 * 
	 */
	public Transacao(Long idTransacao, Conta conta, BigDecimal valor, Date data, String descricao) {
		this.idTransacao = idTransacao;
		this.conta = conta;
		this.valor = valor;
		this.data = data;
		this.descricao = descricao;
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
	 * Método responsável por retornar o id da conta 
	 * relacionada à instância
	 * 
	 * @return o id da conta relacionada à instância em questão
	 */
	public Conta getConta() {
		return conta;
	}

	/** 
	 * Método responsável por atribuir o id da conta relacionada à instância 
	 * 
	 * @param conta identificador da conta a ser atribuido à instância
	 */
	public void setConta(Conta conta) {
		this.conta = conta;
	}

	/** 
	 * Método responsável por retornar o valor
	 * relacionado à instância
	 * 
	 * @return o valor relacionado à instância em questão
	 */
	public BigDecimal getValor() {
		return valor;
	}

	/** 
	 * Método responsável por atribuir o id da conta relacionada à instância 
	 * 
	 * @param valor valor a ser atribuido à instância
	 */
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	/** 
	 * Método responsável por retornar o data
	 * relacionado à instância
	 * 
	 * @return a data relacionado à instância em questão
	 */
	public Date getData() {
		return data;
	}

	/** 
	 * Método responsável por atribuir a data relacionada à instância 
	 * 
	 * @param data data a ser atribuida à instância
	 */
	public void setData(Date data) {
		this.data = data;
	}

	/** 
	 * Método responsável por retornar a descrição
	 * relacionado à instância
	 * 
	 * @return a descrição relacionado à instância em questão
	 */
	public String getDescricao() {
		return descricao;
	}

	/** 
	 * Método responsável por atribuir a descrição relacionada à instância 
	 * 
	 * @param descricao descrição a ser atribuida à instância
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	/** 
	 * Método responsável por formatar a apresentação de uma instância 
	 * 
	 * @return a instância formatada de modo legível
	 */
	@Override
	public String toString() {
		return "Transacao [idTransacao=" + idTransacao + ", conta=" + conta + ", valor=" + valor + ", data=" + data
				+ "]";
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
		return Objects.hash(idTransacao);
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
		Transacao other = (Transacao) obj;
		return Objects.equals(idTransacao, other.idTransacao);
	}
	
}
