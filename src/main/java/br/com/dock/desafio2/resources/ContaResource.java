package br.com.dock.desafio2.resources;

import java.math.BigDecimal;
import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.dock.desafio2.dto.ContaDTO;
import br.com.dock.desafio2.dto.ValorDTO;
import br.com.dock.desafio2.services.ContaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


/**
 * Classe responsável por interceptar e controlar 
 * o envio de requisições relacionadas ao contexto da classe Conta
 * 
 * @author Gabriel Crespo de Souza
 * @version 1.0
 *
 */

@RestController
@RequestMapping(value = "/contas")
@Api(value = "API gerenciadora de transações de uma conta", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE, tags = {"Contas"}  )
public class ContaResource {

	/**
	 *  Dependência da classe serviço de conta injetada com o intuito de 
	 * 	invocar comunicações com a camada de dados da aplicação
	 */
	@Autowired
	private ContaService service;

	/**
	 * Método responsável por mapear a rota que buscará os dados de uma conta
	 * 
	 * @param id identificador da conta a ser encontrada
	 * @return uma entidade de resposta com os dados de transferência de uma conta
	 * 
	 */
	@GetMapping(value = "/buscar-conta/{id}")
	@ApiOperation(value = "Consultar informações de uma conta")
	public ResponseEntity<ContaDTO> buscar(@PathVariable long id) {
		return ResponseEntity.ok().body(service.buscar(id));
	}

	/**
	 * Método responsável por mapear a rota que buscará os dados de todas as contas cadastradas
	 * 
	 * @return uma entidade de resposta com os dados de transferência de todas as contadas cadastradas
	 * 
	 */
	@GetMapping
	@ApiOperation(value = "Consultar informações de todas as contas")
	public ResponseEntity<List<ContaDTO>> buscarTodos() {
		List<ContaDTO> contas = service.buscarTodos();
		return ResponseEntity.ok().body(contas);
	}

	/**
	 * Método responsável por mapear a rota que buscará o saldo de uma determinada conta
	 * 
	 * @param id identificador da conta a ser encontrada para consulta do seu saldo
	 * @return uma entidade de resposta com o dado de saldo da conta consultada
	 * 
	 */
	@GetMapping(value = "/consultar-saldo/{id}")
	@ApiOperation(value = "Consultar informações de saldo de uma conta")
	public ResponseEntity<Map<String, BigDecimal>> consultarSaldo(@PathVariable Long id) {
		Map<String, BigDecimal> response = new HashMap<>();
		response.put("Saldo: ", service.consultarSaldo(id));
		return ResponseEntity.ok().body(response);
	}
	
	/**
	 * Método responsável por mapear a rota irá criar um conta
	 * 
	 * @param dto dados de transeferência que serão mapeados para a criação de uma conta
	 * @return uma entidade de resposta com os dados de transferência da conta criada
	 * 
	 */
	@PostMapping
	@ApiOperation(value = "Criar uma conta", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ContaDTO> create(@RequestBody ContaDTO dto) {
		dto = service.create(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}

	/**
	 * Método responsável por mapear a rota que irá depositar um valor monetário 
	 * a uma determinada conta
	 * 
	 * @param id identificador da conta a ser encontrada
	 * @param dto dados de transferência a serem mapeado do valor a ser depositado na conta
	 * @return uma entidade de resposta com os dados de transferência de uma conta
	 * 
	 */
	@PutMapping(value = "/depositar/{id}")
	@ApiOperation(value = "Realizar depósito em uma conta", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ContaDTO> depositar(@PathVariable Long id, @RequestBody ValorDTO dto) {
		ContaDTO contaDto = service.depositar(id, dto);
		return ResponseEntity.ok().body(contaDto);
	}

	/**
	 * Método responsável por mapear a rota que irá sacar um valor monetário 
	 * de uma determinada conta
	 * 
	 * @param id identificador da conta a ser encontrada
	 * @param dto dados de transferência a serem mapeado do valor a ser sacado da conta
	 * @return uma entidade de resposta com os dados de transferência de uma conta
	 * 
	 */
	@PutMapping(value = "/sacar/{id}")
	@ApiOperation(value = "Sacar um valor de uma conta", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ContaDTO> sacar(@PathVariable Long id, @RequestBody ValorDTO dto) {
		ContaDTO contaDto = service.sacar(id, dto);
		return ResponseEntity.ok().body(contaDto);
	}

	/**
	 * Método responsável por mapear a rota que irá bloquear uma conta
	 * 
	 * @param id identificador da conta a ser encontrada
	 * @return uma entidade de resposta com os dados de transferência de uma conta
	 * 
	 */
	@PutMapping(value = "/bloquear/{id}")
	@ApiOperation(value = "Bloquear uma conta", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ContaDTO> bloquear(@PathVariable Long id) {
		ContaDTO contaDto = service.bloquearConta(id);
		return ResponseEntity.ok().body(contaDto);
	}

	/**
	 * Método responsável por mapear a rota que irá desbloquear uma conta
	 * 
	 * @param id identificador da conta a ser encontrada
	 * @return uma entidade de resposta com os dados de transferência de uma conta
	 * 
	 */
	@PutMapping(value = "/desbloquear/{id}")
	@ApiOperation(value = "desbloquear uma conta", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ContaDTO> desbloquear(@PathVariable Long id) {
		ContaDTO contaDto = service.desbloquearConta(id);
		return ResponseEntity.ok().body(contaDto);
	}


}
