package net.tecgurus.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.tecgurus.dto.CatalogoGeneralDTO;
import net.tecgurus.entities.CatalogoGeneral;
import net.tecgurus.persistence.CatalogoDAO;
import net.tecgurus.persistence.dao.GenericDAO;
import net.tecgurus.service.CatalogoService;
import net.tecgurus.service.assembler.Assembler;
import net.tecgurus.service.assembler.CatalogoGeneralAssembler;

@Service
public class CatalogoGeneralServiceImpl extends GenericServiceImpl<CatalogoGeneral, CatalogoGeneralDTO, Integer>
		implements CatalogoService {

	@Autowired
	private CatalogoDAO dao;
	@Autowired
	private CatalogoGeneralAssembler assembler;
	
	@Override
	protected GenericDAO<CatalogoGeneral, Integer> getDAO() {
		return dao;
	}
	@Override
	protected Assembler<CatalogoGeneralDTO, CatalogoGeneral> getAssembler() {
		return assembler;
	}

	/*
	public List<CatalogoGeneralDTO> findAll() {
		try {
			List<CatalogoGeneral> listBD = dao.getAll();
			List<CatalogoGeneralDTO> listDTO = assembler.getDTOListTransform(listBD);
			return listDTO;
		} catch (PersistenceException e) {
			return null;
		}
	}
	*/

}
