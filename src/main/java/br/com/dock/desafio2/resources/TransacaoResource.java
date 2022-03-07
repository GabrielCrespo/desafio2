package br.com.dock.desafio2.resources;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.dock.desafio2.dto.TransacaoDTO;
import br.com.dock.desafio2.services.TransacaoService;

@RestController
@RequestMapping(value = "/transacao")
public class TransacaoResource {
	
	@Autowired
	TransacaoService service;

	@GetMapping(value = "/consultar-transacoes/{id}")
	public ResponseEntity<List<TransacaoDTO>> BuscarTransacoes(@PathVariable Long id) {
		List<TransacaoDTO> transacoes = service.buscarTransacoes(id);
		return ResponseEntity.ok().body(transacoes);
	}

	@GetMapping(value = "/consultar-transacoes-por-periodo/{id}")
	public ResponseEntity<List<TransacaoDTO>> BuscarTransacoesPorPeriod(@PathVariable Long id,
			@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date start,
			@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date end) {
		List<TransacaoDTO> transacoes = service.buscarTransacoesPorPeriodo(id, start, end);
		return ResponseEntity.ok().body(transacoes);
	}
	
}
