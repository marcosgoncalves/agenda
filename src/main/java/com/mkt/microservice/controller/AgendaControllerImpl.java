package com.mkt.microservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mkt.microservice.entity.Contato;
import com.mkt.microservice.service.AgendaService;

/**
 * Esse é o controller.
 * Aqui começa o processo.
 * Onde são recebidas e tratadas as requisições.
 * Os dados recebidos são passados para a camada service.
*/

@RestController
@RequestMapping("/agenda")
public class AgendaControllerImpl implements AgendaController {
	
	@Autowired private AgendaService service;

	@GetMapping("/contato")
	public ResponseEntity<List<Contato>> get() {
		List<Contato> get = service.get();
		return new ResponseEntity<>(get, HttpStatus.OK);
    }

	@GetMapping(value="/contato/{id}")
	public ResponseEntity<Contato> get(@PathVariable Integer id) {
		Contato get = service.get(id);
		return new ResponseEntity<>(get, HttpStatus.OK);
    }
	
	@PostMapping(value = "/contato")
	public ResponseEntity<Contato> post(@RequestBody Contato contato) {
		service.insert(contato);
		return new ResponseEntity<>(HttpStatus.OK);
    }
	
	@RequestMapping(value = "/contato", method = RequestMethod.PUT)
	public ResponseEntity<Contato> update(@RequestBody Contato contato) {
		service.update(contato);
		return new ResponseEntity<>(HttpStatus.OK);
    }

	@RequestMapping(value = "/contato", method = RequestMethod.DELETE)
	public ResponseEntity<Contato> delete(@RequestBody Contato contato) {
		service.delete(contato);
		return new ResponseEntity<>(HttpStatus.OK);
    }
	
}
