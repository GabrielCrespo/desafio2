package br.com.dock.desafio2.resources;

import java.math.BigDecimal;
import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
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
import br.com.dock.desafio2.dto.DepositoDTO;
import br.com.dock.desafio2.entities.Conta;
import br.com.dock.desafio2.services.ContaService;

@RestController
@RequestMapping(value = "/contas")
public class ContaResource {
	
	@Autowired
	private ContaService service;
	
	@GetMapping
	public ResponseEntity<List<Conta>> findAll(){
		List<Conta> contas = service.findAll();
		return ResponseEntity.ok().body(contas);
	}
	
	@GetMapping(value = "/consutar-saldo/{id}")
	public ResponseEntity<Map<String, BigDecimal>> consultarSaldo(@PathVariable Long id) {
		Map<String, BigDecimal> response = new HashMap<>();
		response.put("Saldo: ", service.consultarSaldo(id));
		return ResponseEntity.ok().body(response);
	}
	
	@PostMapping
	public ResponseEntity<ContaDTO> create(@RequestBody ContaDTO dto) {
		dto = service.create(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<ContaDTO> depositar(@PathVariable Long id, @RequestBody DepositoDTO dto) {
		ContaDTO contaDto = service.depositar(id, dto);
		return ResponseEntity.ok().body(contaDto);
	}
	
	
}