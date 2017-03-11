package net.tecgurus.persistence.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import net.tecgurus.persistence.CatalogoDAO;

@Repository
public class CatalogoDAOImpl implements CatalogoDAO {

	@Autowired
	private SimpleJdbcTemplate template;

	private static final String SQL_QUERY_COUNT = "select count(*) from Catalogo_General";

	@Override
	public void queryTest() {
		long count = template.queryForLong(SQL_QUERY_COUNT);
		System.out.println("Regreso de la consulta de conteo: " + count);
	}

}
