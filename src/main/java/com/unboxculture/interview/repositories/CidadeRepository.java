package com.unboxculture.interview.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unboxculture.interview.entities.Cidade;
import com.unboxculture.interview.entities.EstadoEnum;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> {

	List<Cidade> findByNomeContaining(String nome);

	List<Cidade> findByEstado(EstadoEnum estado);

}
