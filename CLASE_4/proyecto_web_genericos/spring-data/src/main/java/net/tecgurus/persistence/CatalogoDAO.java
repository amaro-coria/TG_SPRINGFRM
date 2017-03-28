package net.tecgurus.persistence;

import java.util.List;

import net.tecgurus.entities.CatalogoGeneral;
import net.tecgurus.persistence.dao.GenericDAO;

public interface CatalogoDAO extends GenericDAO<CatalogoGeneral, Integer> {

	void queryTest();

	List<CatalogoGeneral> findAll();

	CatalogoGeneral findById(Integer id);

	List<CatalogoGeneral> findByDscCrt(String dsc);

	List<CatalogoGeneral> findByDscCrtAndDscCmp(String dscCrt, String dscCmp);

}