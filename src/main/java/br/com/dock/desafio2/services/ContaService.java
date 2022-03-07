package br.com.dock.desafio2.services;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.dock.desafio2.dto.ContaDTO;
import br.com.dock.desafio2.dto.ValorDTO;
import br.com.dock.desafio2.entities.Conta;
import br.com.dock.desafio2.entities.Pessoa;
import br.com.dock.desafio2.repositories.ContaRepository;
import br.com.dock.desafio2.repositories.PessoaRepository;
import br.com.dock.desafio2.services.exceptions.EntityNotFoundException;

@Service
public class ContaService {

	@Autowired
	private ContaRepository contaRepository;

	@Autowired
	private PessoaRepository pessoaRepository;

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
		return new ContaDTO(conta);
		
	}
	
	@Transactional(readOnly = true)
	public BigDecimal consultarSaldo(Long id) {
		Optional<Conta> obj = contaRepository.findById(id);
		Conta conta = obj.orElseThrow(() -> new EntityNotFoundException("Conta não encontrada!"));
		return conta.getSaldo();
	}
	
	public ContaDTO sacar(Long id, ValorDTO dto) {
		Optional<Conta> obj = contaRepository.findById(id);
		Conta conta = obj.orElseThrow(() -> new EntityNotFoundException("Conta não encontrada!"));
		BigDecimal novoSaldo = conta.getSaldo().subtract(dto.getValor());
		conta.setSaldo(novoSaldo);
		conta = contaRepository.save(conta);
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

}
