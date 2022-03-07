package br.com.dock.desafio2.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "transacoes")
public class Transacao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTransacao;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "idConta", referencedColumnName = "idConta")
	private Conta conta;
	
	@Column(precision = 10, scale = 2, nullable = false)
	private BigDecimal valor;
	
	private Date data;
	
	private String descricao;
	
	public Transacao() {
	}

	public Transacao(Long idTransacao, Conta conta, BigDecimal valor, Date data, String descricao) {
		this.idTransacao = idTransacao;
		this.conta = conta;
		this.valor = valor;
		this.data = data;
		this.descricao = descricao;
	}

	public Long getIdTransacao() {
		return idTransacao;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "Transacao [idTransacao=" + idTransacao + ", conta=" + conta + ", valor=" + valor + ", data=" + data
				+ "]";
	}
	
}
