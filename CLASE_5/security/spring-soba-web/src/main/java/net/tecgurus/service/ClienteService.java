package net.tecgurus.service;

import java.util.List;

import net.tecgurus.dto.ClienteDTO;
import net.tecgurus.entities.Cliente;

public interface ClienteService extends GenericService<Cliente, ClienteDTO, Integer> {

	List<ClienteDTO> findFromIdCatalogo(Integer idCatalogo) throws ServiceException;

	List<ClienteDTO> findFromNombreCatalogo(String nombCatalogo) throws ServiceException;

}
