package br.com.dock.desafio2.entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "contas")
public class Conta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idConta;
	
	@ManyToOne
	@JoinColumn(name = "idPessoa", referencedColumnName = "idPessoa")
	private Pessoa idPessoa;
	
	private BigDecimal saldo;
	private BigDecimal limiteSaqueDiario;
	private Boolean flagAtivo;
	private Long tipoConta;
	private Date dataCriacao;
	
	@OneToMany(mappedBy = "idTransacao")
	private List<Transacao> transacoes = new ArrayList<Transacao>();

	public Conta() {

	}

	public Conta(Long idConta, Pessoa idPessoa, BigDecimal saldo, BigDecimal limiteSaqueDiario, Boolean flagAtivo,
			Long tipoConta, Date dataCriacao) {
		this.idConta = idConta;
		this.idPessoa = idPessoa;
		this.saldo = saldo;
		this.limiteSaqueDiario = limiteSaqueDiario;
		this.flagAtivo = flagAtivo;
		this.tipoConta = tipoConta;
		this.dataCriacao = dataCriacao;
	}

	public Long getIdConta() {
		return idConta;
	}

	public Pessoa getIdPessoa() {
		return idPessoa;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	public BigDecimal getLimiteSaqueDiario() {
		return limiteSaqueDiario;
	}

	public void setLimiteSaqueDiario(BigDecimal limiteSaqueDiario) {
		this.limiteSaqueDiario = limiteSaqueDiario;
	}

	public Boolean getFlagAtivo() {
		return flagAtivo;
	}

	public void setFlagAtivo(Boolean flagAtivo) {
		this.flagAtivo = flagAtivo;
	}

	public Long getTipoConta() {
		return tipoConta;
	}

	public void setTipoConta(Long tipoConta) {
		this.tipoConta = tipoConta;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public List<Transacao> getTransacoes() {
		return transacoes;
	}

}
