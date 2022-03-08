package br.com.dock.desafio2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.dock.desafio2.entities.Conta;


/**
 * Repositório responsável por realizar as operações de banco de dados
 * relacionadas à classe Conta
 * 
 * @author Gabriel Crespo de Souza
 * @version 1.0
 *
 */

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long> {

}
