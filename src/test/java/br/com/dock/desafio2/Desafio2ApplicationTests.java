package br.com.dock.desafio2;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.EnumMap;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.dock.desafio2.dto.ContaDTO;
import br.com.dock.desafio2.dto.TransacaoDTO;
import br.com.dock.desafio2.dto.ValorDTO;
import br.com.dock.desafio2.entities.Conta;
import br.com.dock.desafio2.entities.Pessoa;
import br.com.dock.desafio2.enums.TipoConta;
import br.com.dock.desafio2.repositories.ContaRepository;
import br.com.dock.desafio2.repositories.PessoaRepository;
import br.com.dock.desafio2.services.ContaService;
import br.com.dock.desafio2.services.TransacaoService;

@SpringBootTest
class Desafio2ApplicationTests {

	@Autowired
	ContaService service;

	@Autowired
	TransacaoService transacaoService;

	@Autowired
	ContaRepository contaRepository;

	@Autowired
	PessoaRepository pessoaRepository;

	@Test
	public void criarContaTeste() {

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

	@Test
	public void buscarContaTeste() {

		ContaDTO dto = service.buscar(contaRepository.findAll().get(0).getIdConta());

		assertNotNull(dto);
	}

	@Test
	public void buscarTodasAsContasTeste() {

		List<ContaDTO> dtos = service.buscarTodos();

		assertTrue(dtos.size() > 0);
	}

	@Test
	public void buscarTodasOsTiposDeContaTeste() {

		EnumMap<TipoConta, Integer> tiposDeContas = service.buscarTiposDeConta();

		assertTrue(tiposDeContas.size() > 0);
	}

	@Test
	public void depositarValorTeste() {

		Conta conta = contaRepository.findAll().get(0);
		Long id = conta.getIdConta();
		BigDecimal saldoAtual = conta.getSaldo();

		ValorDTO valorDto = new ValorDTO(new BigDecimal(100));

		service.depositar(id, valorDto);
		conta = contaRepository.findById(id).get();

		assertEquals(conta.getSaldo(), valorDto.getValor().add(saldoAtual));
	}

	@Test
	public void consultarSaldoTeste() {

		Conta conta = contaRepository.findAll().get(0);
		Long id = conta.getIdConta();
		BigDecimal saldoAtual = conta.getSaldo();

		BigDecimal saldo = service.consultarSaldo(id);

		assertEquals(saldo, saldoAtual);
	}

	@Test
	public void sacarValorTeste() {

		Conta conta = contaRepository.findAll().get(1);
		Long id = conta.getIdConta();

		ValorDTO valorDepositoDto = new ValorDTO(new BigDecimal(100));

		service.depositar(id, valorDepositoDto);

		conta = contaRepository.findById(id).get();
		BigDecimal saldoAtual = conta.getSaldo();

		ValorDTO valorsaqueDto = new ValorDTO(new BigDecimal(50));

		service.sacar(id, valorsaqueDto);
		conta = contaRepository.findById(id).get();
		BigDecimal saldoAposSaque = conta.getSaldo();

		assertEquals(saldoAposSaque, saldoAtual.subtract(valorsaqueDto.getValor()));
	}

	@Test
	public void desbloquearBloquearContaTeste() {

		Conta conta = contaRepository.findAll().get(2);
		Long id = conta.getIdConta();
		Boolean statusInicial = conta.getFlagAtivo();

		if (conta.getFlagAtivo()) {
			service.bloquearConta(id);
		} else {
			service.desbloquearConta(id);
		}

		conta = contaRepository.findById(id).get();
		System.out.println(statusInicial);
		System.out.println(!conta.getFlagAtivo());

		assertEquals(statusInicial, !conta.getFlagAtivo());
	}

	@Test
	public void buscarTodasAsTransacoesPorIdTeste() {

		Conta conta = contaRepository.findAll().get(2);
		Long id = conta.getIdConta();

		List<TransacaoDTO> dtos = transacaoService.buscarTransacoes(id);

		assertTrue(dtos.size() > 0);
	}
	
	@Test
	public void buscarTodasAsTransacoesPorPeriodoTeste() {

		Conta conta = contaRepository.findAll().get(2);
		Long id = conta.getIdConta();
		
		List<TransacaoDTO> dtos = null;
		
		Date initalDate;
		Date finalDate;
		try {
			initalDate= new SimpleDateFormat("yyyy-MM-dd").parse("2022-01-01");
			finalDate = new SimpleDateFormat("yyyy-MM-dd").parse("2022-01-31");
			dtos = transacaoService.buscarTransacoesPorPeriodo(id, initalDate, finalDate);
		} catch (ParseException e) {
			e.getMessage();
		}


		assertTrue(dtos.size() > 0);
	}
}
