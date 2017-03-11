package net.tecgurus.persistence.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.tecgurus.entities.CatalogoGeneral;
import net.tecgurus.persistence.CatalogoDAO;

@Repository
@Transactional
public class CatalogoDAOImpl implements CatalogoDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	

	@Override
	public void queryTest() {
		Object o = sessionFactory.getCurrentSession().get(CatalogoGeneral.class, new Integer(2));
		System.out.println(o);
	}
/*
	@Autowired
	private SimpleJdbcTemplate template;

	private static final String SQL_QUERY_COUNT = "select count(*) from Catalogo_General";

	@Override
	public void queryTest() {
		long count = template.queryForLong(SQL_QUERY_COUNT);
		System.out.println("Regreso de la consulta de conteo: " + count);
	}
*/
}
