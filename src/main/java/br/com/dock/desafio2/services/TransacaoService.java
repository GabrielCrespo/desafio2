package br.com.dock.desafio2.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dock.desafio2.dto.TransacaoDTO;
import br.com.dock.desafio2.entities.Conta;
import br.com.dock.desafio2.repositories.ContaRepository;
import br.com.dock.desafio2.repositories.TransacaoRepository;
import br.com.dock.desafio2.services.exceptions.BlockedAccountException;
import br.com.dock.desafio2.services.exceptions.EntityNotFoundException;


/**
 * Classe responsável por estabelecer todas as regras de 
 * negócio da aplicação no contexto da entidade Transação 
 * 
 * @author Gabriel Crespo de Souza
 * @version 1.0
 *
 */

@Service
public class TransacaoService {
	
	/**
	 *  Dependência da classe repositório de conta injetada com o intuito de 
	 * 	invocar comunicações diretas com a entidade Transação na base de dados
	 */
	@Autowired
	TransacaoRepository transacaoRepository;
	
	/**
	 *  Dependência da classe repositório de conta injetada com o intuito de 
	 * 	invocar comunicações diretas com a entidade Conta na base de dados
	 */
	@Autowired
	ContaRepository contaRepository;
	
	/**
	 * Método responsável por consultar a camada de dados
	 * em busca de todas as transações realizadas por uma 
	 * determinada conta.
	 * 
	 * @param id identificador da conta a serem encontrada suas transações
	 * @return uma lista com os dados de transferência das transações consultadas
	 * @throws BlockedAccountException se a conta estiver bloqueada
	 * 
	 */
	public List<TransacaoDTO> buscarTransacoes(Long id) {

		Optional<Conta> obj = contaRepository.findById(id);
		Conta conta = obj.orElseThrow(() -> new EntityNotFoundException("Conta não encontrada!"));

		if (!conta.getFlagAtivo()) {
			throw new BlockedAccountException("A conta está bloqueada");
		}

		return transacaoRepository.findAll().stream().map((transacao) -> new TransacaoDTO(transacao))
				.collect(Collectors.toList());
	}

	/**
	 * Método responsável por consultar a camada de dados
	 * em busca de todas as transações realizadas por uma 
	 * determinada conta em um determinado período.
	 * 
	 * @param id identificador da conta a serem encontrada suas transações
	 * @param start data de início do período a ser consultado
	 * @param end data de início do período a ser consultado
	 * @return uma lista com os dados de transferência das transações consultadas
	 * @throws BlockedAccountException se a conta estiver bloqueada
	 * 
	 */
	public List<TransacaoDTO> buscarTransacoesPorPeriodo(Long id, Date start, Date end) {
	
		Optional<Conta> obj = contaRepository.findById(id);
		Conta conta = obj.orElseThrow(() -> new EntityNotFoundException("Conta não encontrada!"));

		if (!conta.getFlagAtivo()) {
			throw new BlockedAccountException("A conta está bloqueada");
		}

		return transacaoRepository.findByDataBetween(start, end).stream().map((transacao) -> new TransacaoDTO(transacao))
				.collect(Collectors.toList());
	}

}
