package br.com.dock.desafio2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.dock.desafio2.entities.Pessoa;

/**
 * Repositório responsável por realizar as operações de banco de dados
 * relacionadas à classe Pessoa
 * 
 * @author Gabriel Crespo de Souza
 * @version 1.0
 *
 */
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
