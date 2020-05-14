package com.unboxculture.interview.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.unboxculture.interview.entities.Cliente;
import com.unboxculture.interview.services.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteResource {

	@Autowired
	private ClienteService service;
	
	@PostMapping
	public ResponseEntity<Cliente> post(@RequestBody Cliente cliente){
		return new ResponseEntity<Cliente>(service.save(cliente), HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> getById(@PathVariable Long id){
		return new ResponseEntity<Cliente>(service.findById(id), HttpStatus.OK);
	}
		
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Cliente>> getByNome(@PathVariable String nome){
		return new ResponseEntity<List<Cliente>>(service.findByNome(nome), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> updateNome(@PathVariable Long id, @RequestParam String nome){
		service.updateNome(nome, id);
		return ResponseEntity.accepted().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		service.remover(id);
		return ResponseEntity.accepted().build();
	}
	
}
