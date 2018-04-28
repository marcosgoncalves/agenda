package com.mkt.microservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mkt.microservice.dao.AgendaDaoImpl;
import com.mkt.microservice.entity.Contato;

/**
 * Esse é o service.
 * Aqui é onde são tratadas as regras de negócio.
 * Quase sempre faz nada e repassa a camada DAO.
*/
@Service
public class AgendaServiceImpl implements AgendaService {
	
	@Autowired private AgendaDaoImpl dao;
	
	public List<Contato> get() {
		return dao.get();
	}

	public Contato get(Integer id) {
		return dao.get(id);
	}

	public void push(Contato contato) {
		Contato reg = dao.get(contato.getId());
		if(reg==null) {
			dao.insert(contato);
		} else {
			dao.update(contato);
		}
	}

	public void delete(Contato contato) {
		dao.delete(contato);
	}
}
