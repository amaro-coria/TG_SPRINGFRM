package net.tecgurus.persistence.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import net.tecgurus.entities.Cliente;
import net.tecgurus.persistence.PersistenceExcepcion;
import net.tecgurus.persistence.dao.ClienteDAO;

@Repository
public class ClienteDAOImpl extends GenericDAOImpl<Cliente, Integer> implements ClienteDAO {

	@Override
	public List<Cliente> findFromIdCatalogo(Integer idCatalogo) throws PersistenceExcepcion {
		try {
			Criteria c = getSessionFactory().getCurrentSession().createCriteria(Cliente.class);
			c.add(Restrictions.eq("idEdoCte.idCat", idCatalogo));
			List l = c.list();
			return l;
		} catch (Exception e) {
			throw new PersistenceExcepcion("Fallo en buscar: " + e.getMessage());
		}
	}

	@Override
	public List<Cliente> findFromNombreCatalogo(String nombCatalogo) throws PersistenceExcepcion {
		try {
			Criteria c = getSessionFactory().getCurrentSession().createCriteria(Cliente.class);
			c = c.createCriteria("idEdoCte");
			c.add(Restrictions.ilike("dscCorCat", nombCatalogo));
			List l = c.list();
			return l;
		} catch (Exception e) {
			throw new PersistenceExcepcion("Fallo en buscar: " + e.getMessage());
		}
	}

}
