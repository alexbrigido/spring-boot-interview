package com.unboxculture.interview.services;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unboxculture.interview.entities.Cidade;
import com.unboxculture.interview.entities.Cliente;
import com.unboxculture.interview.exceptions.ResourceNotFoundException;
import com.unboxculture.interview.repositories.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;
	
	@Autowired
	private CidadeService cidadeService;
	
	public Cliente save(Cliente cliente) {
		if(Objects.nonNull(cliente.getCidade())) {
			Cidade cidade = cidadeService.findById(cliente.getCidade().getId());
			cliente.setCidade(cidade);			
		}
		return repository.save(cliente);
	}
	
	public List<Cliente> findByNome(String nome){
		return repository.findByNomeContaining(nome);
	}
	
	public Cliente findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cliente not found"));
	}
	
	@Transactional
	public void updateNome(String nome, Long id) {
		repository.updateNome(nome, id);
	}

	public void remover(Long id) {
		repository.deleteById(id);
	}
}
