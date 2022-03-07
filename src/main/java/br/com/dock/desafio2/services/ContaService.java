package br.com.dock.desafio2.services;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dock.desafio2.dto.ContaDTO;
import br.com.dock.desafio2.dto.ValorDTO;
import br.com.dock.desafio2.entities.Conta;
import br.com.dock.desafio2.entities.Pessoa;
import br.com.dock.desafio2.entities.Transacao;
import br.com.dock.desafio2.repositories.ContaRepository;
import br.com.dock.desafio2.repositories.PessoaRepository;
import br.com.dock.desafio2.repositories.TransacaoRepository;
import br.com.dock.desafio2.services.exceptions.EntityNotFoundException;

@Service
public class ContaService {

	@Autowired
	private ContaRepository contaRepository;

	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private TransacaoRepository transacaoRepository;
	
	public ContaDTO buscar(Long id) {
		Optional<Conta> obj = contaRepository.findById(id);
		Conta conta = obj.orElseThrow(() -> new EntityNotFoundException("Conta não encontrada!"));
		return new ContaDTO(conta);
	}

	public List<Conta> findAll() {
		return contaRepository.findAll();
	}

	public ContaDTO create(ContaDTO dto) {

		Optional<Pessoa> obj = pessoaRepository.findById(dto.getPessoa().getIdPessoa());
		Pessoa pessoa = obj.orElseThrow(() -> new EntityNotFoundException("Pessoa não encontrada!"));

		Conta conta = new Conta();
		conta.setDataCriacao(new Date());
		conta.setFlagAtivo(false);
		conta.setSaldo(new BigDecimal(0.00));
		conta.setTipoConta(dto.getTipoConta());
		conta.setIdPessoa(pessoa);
		conta.setLimiteSaqueDiario(dto.getLimiteSaqueDiario());

		contaRepository.save(conta);

		return new ContaDTO(conta);

	}
	
	public ContaDTO depositar(Long id, ValorDTO dto) {
		Optional<Conta> obj = contaRepository.findById(id);
		Conta conta = obj.orElseThrow(() -> new EntityNotFoundException("Conta não encontrada!"));
		BigDecimal novoSaldo = conta.getSaldo().add(dto.getValor());
		conta.setSaldo(novoSaldo);
		conta = contaRepository.save(conta);
		
		Transacao deposito = new Transacao(null, conta, dto.getValor(), new Date(), "Depósito");
		transacaoRepository.save(deposito);
		
		return new ContaDTO(conta);
		
	}
	
	public BigDecimal consultarSaldo(Long id) {
		Optional<Conta> obj = contaRepository.findById(id);
		Conta conta = obj.orElseThrow(() -> new EntityNotFoundException("Conta não encontrada!"));
		Transacao consulta = new Transacao(null, conta, new BigDecimal(0.00), new Date(), "Consulta");
		transacaoRepository.save(consulta);
		
		return conta.getSaldo();
	}
	
	public ContaDTO sacar(Long id, ValorDTO dto) {
		Optional<Conta> obj = contaRepository.findById(id);
		Conta conta = obj.orElseThrow(() -> new EntityNotFoundException("Conta não encontrada!"));
		BigDecimal novoSaldo = conta.getSaldo().subtract(dto.getValor());
		conta.setSaldo(novoSaldo);
		conta = contaRepository.save(conta);
		
		Transacao deposito = new Transacao(null, conta, dto.getValor(), new Date(), "Saque");
		transacaoRepository.save(deposito);
		
		return new ContaDTO(conta);
	}
	
	public ContaDTO bloquearConta(Long id) {
		Optional<Conta> obj = contaRepository.findById(id);
		Conta conta = obj.orElseThrow(() -> new EntityNotFoundException("Conta não encontrada!"));
		conta.setFlagAtivo(false);
		return new ContaDTO(conta);
	}
	
	public ContaDTO desbloquearConta(Long id) {
		Optional<Conta> obj = contaRepository.findById(id);
		Conta conta = obj.orElseThrow(() -> new EntityNotFoundException("Conta não encontrada!"));
		conta.setFlagAtivo(true);
		return new ContaDTO(conta);
	}
	
	public List<Transacao> buscarTransacoes(Long id) {
		return transacaoRepository.findAll();
	}

}
