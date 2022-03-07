package br.com.dock.desafio2.services;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dock.desafio2.dto.TransacaoDTO;
import br.com.dock.desafio2.entities.Conta;
import br.com.dock.desafio2.repositories.ContaRepository;
import br.com.dock.desafio2.repositories.TransacaoRepository;
import br.com.dock.desafio2.services.exceptions.BlockedAccountException;

@Service
public class TransacaoService {
	
	@Autowired
	TransacaoRepository transacaoRepository;
	
	@Autowired
	ContaRepository contaRepository;
	
	public List<TransacaoDTO> buscarTransacoes(Long id) {

		Conta conta = contaRepository.findById(id).get();

		if (!conta.getFlagAtivo()) {
			throw new BlockedAccountException("A conta está bloqueada");
		}

		return transacaoRepository.findAll().stream().map((transacao) -> new TransacaoDTO(transacao))
				.collect(Collectors.toList());
	}

	public List<TransacaoDTO> buscarTransacoesPorPeriodo(Long id, Date start, Date end) {

		Conta conta = contaRepository.findById(id).get();

		if (!conta.getFlagAtivo()) {
			throw new BlockedAccountException("A conta está bloqueada");
		}

		return transacaoRepository.findByDataBetween(start, end).stream().map((transacao) -> new TransacaoDTO(transacao))
				.collect(Collectors.toList());
	}

}
