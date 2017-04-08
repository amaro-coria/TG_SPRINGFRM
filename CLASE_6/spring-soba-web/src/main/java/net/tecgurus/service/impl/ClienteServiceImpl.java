package net.tecgurus.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.tecgurus.dto.ClienteDTO;
import net.tecgurus.entities.Cliente;
import net.tecgurus.persistence.PersistenceExcepcion;
import net.tecgurus.persistence.dao.ClienteDAO;
import net.tecgurus.persistence.dao.GenericDAO;
import net.tecgurus.service.ClienteService;
import net.tecgurus.service.ServiceException;
import net.tecgurus.service.assembler.Assembler;
import net.tecgurus.service.assembler.ClienteAssembler;

@Service
public class ClienteServiceImpl extends GenericServiceImpl<Cliente, ClienteDTO, Integer> implements ClienteService {

	@Autowired
	private ClienteDAO dao;
	@Autowired
	private ClienteAssembler assembler;

	@Override
	protected GenericDAO<Cliente, Integer> getDAO() {
		return dao;
	}

	@Override
	protected Assembler<ClienteDTO, Cliente> getAssembler() {
		return assembler;
	}

	@Override
	public List<ClienteDTO> findFromIdCatalogo(Integer idCatalogo) throws ServiceException {
		try {
			List<Cliente> listEntities = dao.findFromIdCatalogo(idCatalogo);
			List<ClienteDTO> listDTO = assembler.getDTOListTransform(listEntities);
			return listDTO;
		} catch (PersistenceExcepcion e) {
			throw new ServiceException();
		}
	}

	@Override
	public List<ClienteDTO> findFromNombreCatalogo(String nombCatalogo) throws ServiceException {
		try {
			List<Cliente> listEntities = dao.findFromNombreCatalogo(nombCatalogo);
			List<ClienteDTO> listDTO = assembler.getDTOListTransform(listEntities);
			return listDTO;
		} catch (PersistenceExcepcion e) {
			throw new ServiceException();
		}
	}

}
