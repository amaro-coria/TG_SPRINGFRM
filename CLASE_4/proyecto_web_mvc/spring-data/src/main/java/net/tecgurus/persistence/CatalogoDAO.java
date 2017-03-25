package net.tecgurus.persistence;

import java.util.List;

import net.tecgurus.entities.CatalogoGeneral;

public interface CatalogoDAO {
	
	void queryTest();
	
	List<CatalogoGeneral> findAll();
	
	CatalogoGeneral findById(Integer id);
	
	Integer save(CatalogoGeneral c);
	
	void update(CatalogoGeneral c);
	
	void delete(CatalogoGeneral c);
	
	List<CatalogoGeneral> findByDscCrt(String dsc);
	
	List<CatalogoGeneral> findByDscCrtAndDscCmp(String dscCrt, String dscCmp);

}