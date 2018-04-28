package com.mkt.microservice.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.mkt.microservice.entity.Contato;

/* essa bagaça roda a cada linha mapeando os campos para o POJO "Contato" */
@Component
public class ContatoRowMapper implements RowMapper<Contato> {

	@Override
	public Contato mapRow(ResultSet rs, int rowNum) throws SQLException {
		Contato contato = new Contato();
		contato.setId(rs.getInt("id"));
		contato.setNome(rs.getString("nome"));
		contato.setEndereco(rs.getString("endereco"));
		contato.setTelefone(rs.getString("telefone"));
		return contato;
	}
}