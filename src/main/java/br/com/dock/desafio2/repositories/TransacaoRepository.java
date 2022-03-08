package br.com.dock.desafio2.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.dock.desafio2.entities.Transacao;

/**
 * Repositório responsável por realizar as operações de banco de dados
 * relacionadas à classe Transação
 * 
 * @author Gabriel Crespo de Souza
 * @version 1.0
 *
 */

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
	
	/**
	 * Método responsável por buscar transações que estejam entre
	 * um determinado período 
	 * 
	 * @param start data inicial do período
	 * @param end data final do período
	 * @return no return
	 * 
	 */
	List<Transacao> findByDataBetween(Date start, Date end); 

}
