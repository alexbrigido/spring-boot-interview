package com.unboxculture.interview.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unboxculture.interview.entities.Cidade;
import com.unboxculture.interview.entities.EstadoEnum;
import com.unboxculture.interview.exceptions.ResourceNotFoundException;
import com.unboxculture.interview.repositories.CidadeRepository;

@Service
public class CidadeService {

	@Autowired
	private CidadeRepository repository;
	
	public Cidade save(Cidade cidade) {
		return repository.save(cidade);
	}

	public List<Cidade> findbByNome(String nome) {
		return repository.findByNomeContaining(nome);
	}

	public List<Cidade> findbByEstado(EstadoEnum estado) {
		return repository.findByEstado(estado);
	}

	public Cidade findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cidade not found"));
	}
	
}
