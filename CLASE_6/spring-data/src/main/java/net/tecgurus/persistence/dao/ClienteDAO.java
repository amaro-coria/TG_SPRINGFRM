package net.tecgurus.persistence.dao;

import java.util.List;

import net.tecgurus.entities.Cliente;
import net.tecgurus.persistence.PersistenceExcepcion;

public interface ClienteDAO extends GenericDAO<Cliente, Integer> {

	List<Cliente> findFromIdCatalogo(Integer idCatalogo) throws PersistenceExcepcion;

	List<Cliente> findFromNombreCatalogo(String nombCatalogo) throws PersistenceExcepcion;

}
