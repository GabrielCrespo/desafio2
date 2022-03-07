package br.com.dock.desafio2.dto;

import java.math.BigDecimal;

public class ValorDTO {

	private BigDecimal valor;
	
	public ValorDTO() {
	}

	public ValorDTO(BigDecimal valor) {
		this.valor = valor;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
}
