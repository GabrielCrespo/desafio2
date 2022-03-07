package br.com.dock.desafio2.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.dock.desafio2.entities.Transacao;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
	
	List<Transacao> findByDataBetween(Date start, Date end); 

}
