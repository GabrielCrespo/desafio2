package br.com.dock.desafio2.dto;

import java.math.BigDecimal;

public class DepositoDTO {

	private BigDecimal valor;
	
	public DepositoDTO() {
	}

	public DepositoDTO(BigDecimal valor) {
		this.valor = valor;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
}
