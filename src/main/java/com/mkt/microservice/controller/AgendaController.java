package com.mkt.microservice.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.mkt.microservice.entity.Contato;

public interface AgendaController {
    ResponseEntity<List<Contato>> get();
    ResponseEntity<Contato> get(@PathVariable Integer id);
	ResponseEntity<Contato> post(@RequestBody Contato contato);
	ResponseEntity<Contato> update(@RequestBody Contato contato);
	ResponseEntity<Contato> delete(@RequestBody Contato contato);
}
