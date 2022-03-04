package br.com.dock.desafio2.services;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dock.desafio2.dto.ContaDTO;
import br.com.dock.desafio2.dto.DepositoDTO;
import br.com.dock.desafio2.entities.Conta;
import br.com.dock.desafio2.entities.Pessoa;
import br.com.dock.desafio2.repositories.ContaRepository;
import br.com.dock.desafio2.repositories.PessoaRepository;

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

		Pessoa pessoa = pessoaRepository.findById(dto.getPessoa().getIdPessoa()).get();

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
	
	public ContaDTO depositar(Long id, DepositoDTO dto) {
		Conta conta = contaRepository.findById(id).get();
		BigDecimal novoSaldo = conta.getSaldo().add(dto.getValor());
		conta.setSaldo(novoSaldo);
		conta = contaRepository.save(conta);
		return new ContaDTO(conta);
		
	}
	
	public BigDecimal consultarSaldo(Long id) {
		Conta conta = contaRepository.findById(id).get();
		return conta.getSaldo();
	}

}
