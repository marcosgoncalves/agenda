package com.mkt.microservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.mkt.microservice.dao.AgendaDAO;
import com.mkt.microservice.entity.Contato;

/**
 * Esse é o service.
 * Aqui é onde são tratadas as regras de negócio.
 * Quase sempre faz nada e repassa a camada DAO.
*/

@Service
public class AgendaServiceImpl implements AgendaService {
	
	@Autowired private AgendaDAO dao;
	
	public List<Contato> get() {
		return dao.get();
	}

	public Contato get(Integer id) {
		return dao.get(id);
	}

	public void insert(Contato contato) {
		dao.insert(contato);
	}

	public void update(Contato contato) {
		dao.update(contato);
	}

	public void push(Contato contato) {
		Contato reg = null;
		
		try {
			reg = dao.get(contato.getId());
		} catch(EmptyResultDataAccessException e) {
		}
		
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
