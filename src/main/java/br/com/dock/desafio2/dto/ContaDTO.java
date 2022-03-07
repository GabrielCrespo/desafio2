package br.com.dock.desafio2.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import br.com.dock.desafio2.entities.Conta;
import br.com.dock.desafio2.entities.Pessoa;
import br.com.dock.desafio2.enums.TipoConta;

public class ContaDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Pessoa pessoa;
	private BigDecimal saldo;
	private BigDecimal limiteSaqueDiario;
	private Boolean flagAtivo;
	private TipoConta tipoConta;
	private Date dataCriacao;
	
	public ContaDTO() {
		
	}

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
	
	public ContaDTO(Conta entity) {
		this.id= entity.getIdConta();
		this.pessoa = entity.getIdPessoa();
		this.saldo = entity.getSaldo();
		this.limiteSaqueDiario = entity.getLimiteSaqueDiario();
		this.flagAtivo = entity.getFlagAtivo();
		this.tipoConta = entity.getTipoConta();
		this.dataCriacao = entity.getDataCriacao();
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
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


}
