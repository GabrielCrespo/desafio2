package br.com.dock.desafio2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.dock.desafio2.entities.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
