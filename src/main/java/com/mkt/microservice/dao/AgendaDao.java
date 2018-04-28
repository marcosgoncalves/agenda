package com.mkt.microservice.dao;

import java.util.List;

import com.mkt.microservice.entity.Contato;

public interface AgendaDao {
	public List<Contato> get();

	public Contato get(Integer integer);

	public void insert(Contato contato);
	
	public void update(Contato contato);

	public void delete(Contato contato);
}
