package br.gov.rj.faetec.estoque.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.gov.rj.faetec.estoque.model.Estilo;

@Repository
public interface Estilos extends JpaRepository<Estilo, Long> {

	public Optional<Estilo> findByNomeIgnoreCase(String nome);
	
}
