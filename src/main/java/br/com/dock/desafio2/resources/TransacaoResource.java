package br.com.dock.desafio2.resources;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.dock.desafio2.dto.TransacaoDTO;
import br.com.dock.desafio2.services.TransacaoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Classe responsável por interceptar e controlar 
 * o envio de requisições relacionadas ao contexto da classe Transação
 * 
 * @author Gabriel Crespo de Souza
 * @version 1.0
 *
 */
@RestController
@RequestMapping(value = "/transacao")
@Api(value = "API gerenciadora de transações de uma conta", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE, tags = {"Transação"}  )
public class TransacaoResource {
	
	/**
	 *  Dependência da classe serviço de transações injetada com o intuito de 
	 * 	invocar comunicações com a camada de dados da aplicação
	 */
	@Autowired
	TransacaoService service;
	
	/**
	 * Método responsável por mapear a rota que irá consultar as transações 
	 * realizadas por uma determinada conta
	 * 
	 * @param id identificador da conta a ser encontrada
	 * @return uma entidade de resposta com os dados de transferência das
	 * transações realizadas por uma determinada conta
	 * 
	 */
	@GetMapping(value = "/consultar-transacoes/{id}")
	@ApiOperation(value = "Consulta transações por conta")
	public ResponseEntity<List<TransacaoDTO>> BuscarTransacoes(@PathVariable Long id) {
		List<TransacaoDTO> transacoes = service.buscarTransacoes(id);
		return ResponseEntity.ok().body(transacoes);
	}

	/**
	 * Método responsável por mapear a rota que irá consultar as transações 
	 * realizadas por uma determinada conta, baseando-se no período em que
	 * elas ocorreram
	 * 
	 * @param id identificador da conta a ser encontrada
	 * @param start data inicial do período a serem buscadas as transações
	 * @param end data final do período a serem buscadas as transações
	 * @return uma entidade de resposta com os dados de transferência das
	 * transações realizadas em um determinado périodo por uma determinada conta
	 * 
	 */
	@GetMapping(value = "/consultar-transacoes-por-periodo/{id}")
	@ApiOperation(value = "Consulta transações por conta e período")
	public ResponseEntity<List<TransacaoDTO>> BuscarTransacoesPorPeriod(@PathVariable Long id,
			@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date start,
			@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date end) {
		List<TransacaoDTO> transacoes = service.buscarTransacoesPorPeriodo(id, start, end);
		return ResponseEntity.ok().body(transacoes);
	}
	
}
