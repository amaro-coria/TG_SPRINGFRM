package net.tecgurus.business.service.assembler;

import org.springframework.stereotype.Component;

import net.tecgurus.business.dto.ClienteDTO;
import net.tecgurus.data.entities.Cliente;

@Component
public class ClienteAssembler extends Assembler<ClienteDTO, Cliente>{

	@Override
	public ClienteDTO getDTOTransform(Cliente mapping) {
		if(mapping == null){
			return null;
		}
		ClienteDTO dto = new ClienteDTO();
		dto.setApeMatCte(mapping.getApeMatCte());
		dto.setApePatCte(mapping.getApePatCte());
		dto.setDirCte(mapping.getDirCte());
		dto.setIdCte(mapping.getIdCte());
		dto.setIdEdoCte(mapping.getIdEdoCte());
		dto.setNomCte(mapping.getNomCte());
		dto.setTelCte(mapping.getTelCte());
		return dto;
	}

	@Override
	public Cliente getMappingTransform(ClienteDTO dto) {
		if(dto == null){
			return null;
		}
		Cliente mapping = new Cliente();
		mapping.setApeMatCte(dto.getApeMatCte());
		mapping.setApePatCte(dto.getApePatCte());
		mapping.setDirCte(dto.getDirCte());
		mapping.setIdCte(dto.getIdCte());
		mapping.setIdEdoCte(dto.getIdEdoCte());
		mapping.setNomCte(dto.getNomCte());
		mapping.setTelCte(dto.getTelCte());
		return mapping;
	}

}
