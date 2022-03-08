package br.com.dock.desafio2;

import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.dock.desafio2.dto.ContaDTO;
import br.com.dock.desafio2.entities.Conta;
import br.com.dock.desafio2.entities.Pessoa;
import br.com.dock.desafio2.enums.TipoConta;
import br.com.dock.desafio2.repositories.ContaRepository;
import br.com.dock.desafio2.repositories.PessoaRepository;
import br.com.dock.desafio2.services.ContaService;

@SpringBootTest
class Desafio2ApplicationTests {
	
	
	@Autowired
	ContaService service;
	
	@Autowired
	ContaRepository contaRepository;
	
	@Autowired
	PessoaRepository pessoaRepository;

	@Test
	public void criarConta() {
		
		Pessoa pessoa = pessoaRepository.findById(1L).get();
		
		Conta conta = new Conta();
		
		conta.setDataCriacao(new Date());
		conta.setFlagAtivo(false);
		conta.setSaldo(new BigDecimal(0.00));
		conta.setTipoConta(TipoConta.CONTA_CORRENTE);
		conta.setIdPessoa(pessoa);
		conta.setLimiteSaqueDiario(new BigDecimal(100.00));
		
		ContaDTO dto = service.create(new ContaDTO(conta));
		
		assertNotNull(contaRepository.findById(dto.getId()).get());
	}

}
