package br.com.dock.desafio2.dto;

import java.math.BigDecimal;
import java.util.Date;

import br.com.dock.desafio2.entities.Transacao;

public class TransacaoDTO {
	
	private Long idTransacao;
	private BigDecimal valor;
	private Date data;
	private String descricao;
	
	public TransacaoDTO() {
		
	}

	public TransacaoDTO(Long idTransacao, BigDecimal valor, Date data, String descricao) {
		this.idTransacao = idTransacao;
		this.valor = valor;
		this.data = data;
		this.descricao = descricao;
	}
	
	public TransacaoDTO(Transacao entity) {
		this.idTransacao = entity.getIdTransacao();
		this.valor = entity.getValor();
		this.data = entity.getData();
		this.descricao = entity.getDescricao();
	}

	public Long getIdTransacao() {
		return idTransacao;
	}

	public void setIdTransacao(Long idTransacao) {
		this.idTransacao = idTransacao;
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
	
	

}
