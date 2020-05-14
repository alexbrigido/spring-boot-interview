package com.unboxculture.interview.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.unboxculture.interview.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	List<Cliente> findByNomeContaining(String nome);
	
	@Modifying
	@Query("update Cliente c set c.nome=?1 where c.id=?2")
	void updateNome(String nome, Long id);
}
