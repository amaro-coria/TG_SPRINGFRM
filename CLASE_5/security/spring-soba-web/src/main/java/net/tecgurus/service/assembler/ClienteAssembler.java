package net.tecgurus.service.assembler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.tecgurus.dto.ClienteDTO;
import net.tecgurus.entities.CatalogoGeneral;
import net.tecgurus.entities.Cliente;
import net.tecgurus.persistence.CatalogoDAO;

@Component
public class ClienteAssembler extends Assembler<ClienteDTO, Cliente> {

	@Autowired
	private CatalogoDAO daoCata;

	private String getCataDesc(Integer idCata) {
		CatalogoGeneral c = daoCata.findById(idCata);
		String dsc = c.getDscComCat();
		return dsc;
	}

	@Override
	public ClienteDTO getDTOTransform(Cliente mapping) {
		if (mapping == null) {
			return null;
		}
		ClienteDTO dto = new ClienteDTO();
		dto.setApeMatCte(mapping.getApeMatCte());
		dto.setApePatCte(mapping.getApeMatCte());
		dto.setDirCte(mapping.getDirCte());
		dto.setIdCte(mapping.getIdCte());
		dto.setIdEdoCte(mapping.getIdEdoCte().getIdCat());
		dto.setIdEdoCteDsc(getCataDesc(mapping.getIdEdoCte().getIdCat()));
		dto.setNomCte(mapping.getNomCte());
		dto.setTelCte(mapping.getTelCte());
		return dto;
	}

	@Override
	public Cliente getMappingTransform(ClienteDTO dto) {
		Cliente mapping = new Cliente();
		mapping.setApeMatCte(dto.getApeMatCte());
		mapping.setApePatCte(dto.getApeMatCte());
		mapping.setDirCte(dto.getDirCte());
		mapping.setIdCte(dto.getIdCte());
		CatalogoGeneral c = new CatalogoGeneral();
		c.setIdCat(dto.getIdEdoCte());
		mapping.setIdEdoCte(c);
		mapping.setNomCte(dto.getNomCte());
		mapping.setTelCte(dto.getTelCte());
		return mapping;
	}

}
