package net.tecgurus.business.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.tecgurus.business.dto.ClienteDTO;
import net.tecgurus.business.service.ClienteService;
import net.tecgurus.business.service.assembler.Assembler;
import net.tecgurus.business.service.assembler.ClienteAssembler;
import net.tecgurus.data.entities.Cliente;
import net.tecgurus.data.persistence.dao.ClienteDAO;
import net.tecgurus.data.persistence.dao.GenericDAO;

@Service
public class ClienteServiceImpl extends GenericServiceImpl<ClienteDTO, Integer, Cliente> implements ClienteService {

	@Autowired
	private ClienteDAO dao;
	@Autowired
	private ClienteAssembler assembler;

	@Override
	GenericDAO getDAO() {
		return dao;
	}

	@Override
	Assembler getAssembler() {
		return assembler;
	}

}
