package com.mkt.microservice.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mkt.microservice.entity.Contato;

/**
 * Esse é o dao (Data Access Object).
 * Aqui é onde as operações de banco são tratadas.
*/
@Repository
public class AgendaDaoImpl implements AgendaDao {

	@Autowired private JdbcTemplate jdbcTemplate;
	@Autowired private ContatoRowMapper contatoRowMapper = new ContatoRowMapper();

	public List<Contato> get() {
		return jdbcTemplate.query("select * from contato", contatoRowMapper);
	}

	public Contato get(Integer integer) {
		return jdbcTemplate.queryForObject("select * from contato where id=?", new Object[] { integer }, contatoRowMapper);
	}

	public void insert(Contato contato) {
		String sql = "insert into contato(nome, endereco, telefone) values(?, ?, ?)";
		List<Object> values = new ArrayList<>();
        values.add(contato.getNome());
        values.add(contato.getEndereco());
        values.add(contato.getTelefone());
		jdbcTemplate.update(sql, values.toArray());
	}
	
	public void update(Contato contato) {
		String sql = "update contato set nome = ?, endereco = ?, telefone = ?";
		List<Object> values = new ArrayList<>();
        values.add(contato.getNome());
        values.add(contato.getEndereco());
        values.add(contato.getTelefone());
		jdbcTemplate.update(sql, values.toArray());
	}

	public void delete(Contato contato) {
		String sql = "delete contato where id = ?";
		jdbcTemplate.update(sql, contato.getId());
	}
	
	
}
