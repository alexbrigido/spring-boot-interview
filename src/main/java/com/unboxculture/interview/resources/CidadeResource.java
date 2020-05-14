package com.unboxculture.interview.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unboxculture.interview.entities.Cidade;
import com.unboxculture.interview.entities.EstadoEnum;
import com.unboxculture.interview.services.CidadeService;

@RestController
@RequestMapping(value="/cidades")
public class CidadeResource {

	@Autowired
	private CidadeService service;
	
	@PostMapping
	public ResponseEntity<Cidade> post(@RequestBody Cidade cidade){
		return new ResponseEntity<Cidade>(service.save(cidade), HttpStatus.CREATED);
	}

	@GetMapping("/{nome}")
	public ResponseEntity<List<Cidade>> getByNome(@PathVariable String nome){
		return new ResponseEntity<List<Cidade>>(service.findbByNome(nome), HttpStatus.OK);
	}
	
	@GetMapping("/estado/{estado}")
	public ResponseEntity<List<Cidade>> getByEstado(@PathVariable String estado){
		return new ResponseEntity<List<Cidade>>(service.findbByEstado(EstadoEnum.fromSigla(estado)), HttpStatus.OK);
	}
}
