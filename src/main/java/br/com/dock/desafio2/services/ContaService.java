package br.com.dock.desafio2.services;

import java.math.BigDecimal;
import java.util.Date;
import java.util.EnumMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.dock.desafio2.dto.ContaDTO;
import br.com.dock.desafio2.dto.ValorDTO;
import br.com.dock.desafio2.entities.Conta;
import br.com.dock.desafio2.entities.Pessoa;
import br.com.dock.desafio2.entities.Transacao;
import br.com.dock.desafio2.enums.TipoConta;
import br.com.dock.desafio2.repositories.ContaRepository;
import br.com.dock.desafio2.repositories.PessoaRepository;
import br.com.dock.desafio2.repositories.TransacaoRepository;
import br.com.dock.desafio2.services.exceptions.BlockedAccountException;
import br.com.dock.desafio2.services.exceptions.DailyWithdrawLimitException;
import br.com.dock.desafio2.services.exceptions.EntityNotFoundException;
import br.com.dock.desafio2.services.exceptions.WithdrawNotAllowedException;

/**
 * Classe responsável por estabelecer todas as regras de negócio da aplicação no
 * contexto da entidade Conta
 * 
 * @author Gabriel Crespo de Souza
 * @version 1.0
 *
 */

@Service
public class ContaService {

	/**
	 * Dependência da classe repositório de conta injetada com o intuito de invocar
	 * comunicações diretas com a entidade Conta na base de dados
	 */
	@Autowired
	private ContaRepository contaRepository;

	/**
	 * Dependência da classe repositório de conta injetada com o intuito de invocar
	 * comunicações diretas com a entidade Pessoa na base de dados
	 */
	@Autowired
	private PessoaRepository pessoaRepository;

	/**
	 * Dependência da classe repositório de conta injetada com o intuito de invocar
	 * comunicações diretas com a entidade Transação na base de dados
	 */
	@Autowired
	private TransacaoRepository transacaoRepository;

	/**
	 * Método responsável por consultar a camada de dados em busca da conta
	 * solicitada
	 * 
	 * @param id identificador da conta a ser encontrada para consulta do seu saldo
	 * @return uma entidade com os dados de transferência da conta consultada
	 * @throws EntityNotFoundException se a conta não for encontrada
	 * 
	 */
	@Transactional(readOnly = true)
	public ContaDTO buscar(Long id) {
		Optional<Conta> obj = contaRepository.findById(id);
		Conta conta = obj.orElseThrow(() -> new EntityNotFoundException("Conta não encontrada!"));
		return new ContaDTO(conta);
	}

	/**
	 * Método responsável por consultar a camada de dados em busca de todas as
	 * contas cadastradas
	 * 
	 * @return uma lista com os dados de transferência das contas consultadas
	 * 
	 */
	@Transactional(readOnly = true)
	public List<ContaDTO> buscarTodos() {
		return contaRepository.findAll().stream().map((conta) -> new ContaDTO(conta)).collect(Collectors.toList());
	}

	/**
	 * Método responsável por consultar a camada de dados em busca de todas os
	 * tipos de contas existentes
	 * 
	 * @return uma estrutura chave valor com as informações dos tipos de conta existentes
	 * 
	 */
	@Transactional(readOnly = true)
	public EnumMap<TipoConta, Integer> buscarTiposDeConta() {
		EnumMap<TipoConta, Integer> tipoContaMap = new EnumMap<TipoConta, Integer>(TipoConta.class);

		tipoContaMap.put(TipoConta.CONTA_CORRENTE, 0);
		tipoContaMap.put(TipoConta.CONTA_POUPANCA, 1);
		tipoContaMap.put(TipoConta.CONTA_SALARIO, 2);
		
		return tipoContaMap;
	}

	/**
	 * Método responsável por invocar a camada de dados para a criação de uma conta
	 * 
	 * @param dto dados de transeferência necessários para a criação de uma conta
	 * @return uma entidade com os dados de transferência da conta criada
	 * @throws EntityNotFoundException se não existir a pessoa vinculada à conta
	 * 
	 */
	@Transactional
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

	/**
	 * Método responsável por invocar a camada de dados para a consulta de uma conta
	 * que irá receber o depósito e persistência da transação de depósito
	 * 
	 * @param id  identificador da conta a ser encontrada para receber o depósito
	 * @param dto dado de transferência do valor a ser depositado
	 * @return uma entidade com os dados de transferência da conta depositada
	 * @throws EntityNotFoundException se não existir a pessoa vinculada à conta
	 * @throws BlockedAccountException se a conta estiver bloqueada
	 * 
	 */
	@Transactional
	public ContaDTO depositar(Long id, ValorDTO dto) {

		Conta conta = new Conta(this.buscar(id));

		if (!conta.getFlagAtivo()) {
			throw new BlockedAccountException("A conta está bloqueada");
		}

		BigDecimal novoSaldo = conta.getSaldo().add(dto.getValor());
		conta.setSaldo(novoSaldo);
		conta = contaRepository.save(conta);

		Transacao deposito = new Transacao(null, conta, dto.getValor(), new Date(), "Depósito");
		transacaoRepository.save(deposito);

		return new ContaDTO(conta);

	}

	/**
	 * Método responsável por invocar a camada de dados para a consulta do saldo de
	 * uma determinada conta e persistência da transação de consulta do saldo
	 * 
	 * @param id identificador da conta a ser encontrada para consulta do seu saldo
	 * @return o valor do saldo atual da conta
	 * @throws EntityNotFoundException se não existir a pessoa vinculada à conta
	 * @throws BlockedAccountException se a conta estiver bloqueada
	 * 
	 */
	@Transactional
	public BigDecimal consultarSaldo(Long id) {
		Conta conta = new Conta(this.buscar(id));

		if (!conta.getFlagAtivo()) {
			throw new BlockedAccountException("A conta está bloqueada");
		}

		Transacao consulta = new Transacao(null, conta, new BigDecimal(0.00), new Date(), "Consulta");
		transacaoRepository.save(consulta);

		return conta.getSaldo();
	}

	/**
	 * Método responsável por invocar a camada de dados para a consulta de uma conta
	 * que irá realizar o saque e persistência da transação de saque
	 * 
	 * @param id  identificador da conta a ser encontrada para realizar o
	 * @param dto dado de transferência do valor a ser sacado
	 * @return uma entidade com os dados de transferência da conta que realizou o
	 *         saque
	 * @throws EntityNotFoundException     se não existir a pessoa vinculada à conta
	 * @throws BlockedAccountException     se a conta estiver bloqueada
	 * @throws WithdrawNotAllowedException se o saldo não for o suficiente
	 * @throws DailyWithdrawLimitException se o limite de saque diário for excedido
	 * 
	 */
	@Transactional
	public ContaDTO sacar(Long id, ValorDTO dto) {

		Conta conta = new Conta(this.buscar(id));

		if (!conta.getFlagAtivo()) {
			throw new BlockedAccountException("A conta está bloqueada");
		}

		if (conta.getSaldo().compareTo(dto.getValor()) == -1) {
			throw new WithdrawNotAllowedException("Saldo insuficiente");
		}

		if (conta.getLimiteSaqueDiario().compareTo(dto.getValor()) == -1) {
			throw new DailyWithdrawLimitException("Não é possível sacar mais do que o limite diário permitido");
		}

		BigDecimal novoSaldo = conta.getSaldo().subtract(dto.getValor());
		conta.setSaldo(novoSaldo);
		conta = contaRepository.save(conta);

		Transacao deposito = new Transacao(null, conta, dto.getValor(), new Date(), "Saque");
		transacaoRepository.save(deposito);

		return new ContaDTO(conta);
	}

	/**
	 * Método responsável por invocar a camada de dados para o bloqueio de uma conta
	 * 
	 * @param id identificador da conta a ser encontrada para consulta do seu saldo
	 * @return uma entidade com os dados de transferência da conta bloqueada
	 * @throws EntityNotFoundException se não existir a pessoa vinculada à conta
	 * @throws BlockedAccountException se a conta estiver bloqueada
	 * 
	 */
	@Transactional
	public ContaDTO bloquearConta(Long id) {

		Conta conta = new Conta(this.buscar(id));

		if (!conta.getFlagAtivo()) {
			throw new BlockedAccountException("A conta já está bloqueada");
		}

		conta.setFlagAtivo(false);
		contaRepository.save(conta);

		return new ContaDTO(conta);
	}

	/**
	 * Método responsável por invocar a camada de dados para o desbloqueio de uma
	 * conta
	 * 
	 * @param id identificador da conta a ser encontrada para consulta do seu saldo
	 * @return uma entidade com os dados de transferência da conta desbloqueada
	 * @throws EntityNotFoundException se não existir a pessoa vinculada à conta
	 * @throws BlockedAccountException se a conta estiver desbloqueada
	 * 
	 */
	@Transactional
	public ContaDTO desbloquearConta(Long id) {

		Conta conta = new Conta(this.buscar(id));

		if (conta.getFlagAtivo()) {
			throw new BlockedAccountException("A conta já está desbloqueada");
		}

		conta.setFlagAtivo(true);
		contaRepository.save(conta);

		return new ContaDTO(conta);
	}

}
