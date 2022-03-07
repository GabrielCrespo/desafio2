package br.com.dock.desafio2.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

@Entity
@Table(name = "contas")
public class Conta implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idConta;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "idPessoa", referencedColumnName = "idPessoa")
	private Pessoa idPessoa;

	@Column(precision = 10, scale = 2)
	private BigDecimal saldo;

	@Column(precision = 10, scale = 2)
	private BigDecimal limiteSaqueDiario;
	
	@Column(columnDefinition = "boolean default false")
	private Boolean flagAtivo;
	
	private TipoConta tipoConta;
	private Date dataCriacao;

	@OneToMany(mappedBy = "idTransacao")
	private List<Transacao> transacoes = new ArrayList<Transacao>();

	public Conta() {

	}

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
	
	public Conta(ContaDTO entity) {
		this.idConta= entity.getId();
		this.idPessoa = entity.getPessoa();
		this.saldo = entity.getSaldo();
		this.limiteSaqueDiario = entity.getLimiteSaqueDiario();
		this.flagAtivo = entity.getFlagAtivo();
		this.tipoConta = entity.getTipoConta();
		this.dataCriacao = entity.getDataCriacao();
	}

	public Long getIdConta() {
		return idConta;
	}

	public Pessoa getIdPessoa() {
		return idPessoa;
	}
	
	public void setIdPessoa(Pessoa idPessoa) {
		this.idPessoa = idPessoa;
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

	public TipoConta getTipoConta() {
		return tipoConta;
	}

	public void setTipoConta(TipoConta tipoConta) {
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
