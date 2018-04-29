package com.mkt.microservice.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.mkt.microservice.entity.Contato;

/**
 * Esse é o dao (Data Access Object).
 * Aqui é onde as operações de banco são tratadas.
*/
@Repository
public class AgendaDAOImpl implements AgendaDAO {

	@Autowired private JdbcTemplate jdbcTemplate;
	@Autowired private RowMapper<Contato> contatoRowMapper;

	public List<Contato> get() {
		return jdbcTemplate.query("select * from contato", contatoRowMapper);
	}

	public Contato get(Integer integer) {
		return jdbcTemplate.queryForObject("select * from contato where id=?", new Object[] { integer }, contatoRowMapper);
	}

	public void insert(Contato contato) {
		String sql = "insert into contato(id, nome, endereco, telefone) values (?, ?, ?, ?)";
		List<Object> values = new ArrayList<>();
		values.add(contato.getId());
        values.add(contato.getNome());
        values.add(contato.getEndereco());
        values.add(contato.getTelefone());
		jdbcTemplate.update(sql, values.toArray());
	}
	
	public void update(Contato contato) {
		String sql = "update contato set nome = ?, endereco = ?, telefone = ? where id = ?";
		List<Object> values = new ArrayList<>();
        values.add(contato.getNome());
        values.add(contato.getEndereco());
        values.add(contato.getTelefone());
        values.add(contato.getId());
		jdbcTemplate.update(sql, values.toArray());
	}

	public void delete(Contato contato) {
		String sql = "delete contato where id = ?";
		jdbcTemplate.update(sql, contato.getId());
	}
	
	
}
