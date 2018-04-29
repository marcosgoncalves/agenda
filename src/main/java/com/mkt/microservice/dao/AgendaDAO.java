package com.mkt.microservice.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mkt.microservice.entity.Contato;

@Repository
public interface AgendaDAO {
	public List<Contato> get();

	public Contato get(Integer integer);

	public void insert(Contato contato);
	
	public void update(Contato contato);

	public void delete(Contato contato);
}
