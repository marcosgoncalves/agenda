package com.mkt.microservice.service;

import java.util.List;

import com.mkt.microservice.entity.Contato;

/**
 * Esse é um exemplo de interface.
 * Que é um "mapa" de implementação de um "tipo de objeto".
 * Aqui você define como seu objeto vai ser implementado.
 * Veja a implementação na classe AgendaServiceImpl.
 * Obs.: Nesse projeto, por causa da simplicidade, não seria necessário
 * criar essa interface, fiz só para exemplificar o conceito.
 * Nas outras camadas não terão interfaces.
 * */

public interface AgendaService {
	public List<Contato> get();
	public Contato get(Integer id);
	public void push(Contato contato);
	public void delete(Contato contato);
}
