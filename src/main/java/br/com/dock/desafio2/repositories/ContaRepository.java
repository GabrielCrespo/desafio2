package br.com.dock.desafio2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.dock.desafio2.entities.Conta;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long> {

}
