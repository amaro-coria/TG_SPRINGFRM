package net.tecgurus.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.tecgurus.dto.ClienteDTO;
import net.tecgurus.service.ClienteService;
import net.tecgurus.service.ServiceException;

@Controller
public class ClienteController {

	@Autowired
	private ClienteService serviceCtes;
	private static final Logger log = LoggerFactory.getLogger(ClienteController.class);

	@RequestMapping(value = "/pages/clientes")
	public ModelAndView findAllClientes(ModelAndView mv) {
		List<ClienteDTO> listClientes = new ArrayList<ClienteDTO>();
		try {
			listClientes = serviceCtes.findAll();
		} catch (ServiceException e) {
			log.error("Error en find clientes en controller: {}", e.getMessage());
		}
		mv.addObject("clientesList", listClientes);
		mv.setViewName("pages/clientes");
		return mv;
	}

	@RequestMapping(value = "/pages/clientes/estatus/{idCatalogo}")
	public ModelAndView findAllClientesFromCatalogo(@PathVariable Integer idCatalogo) {
		ModelAndView mv = new ModelAndView();
		List<ClienteDTO> listClientes = new ArrayList<ClienteDTO>();
		try {
			listClientes = serviceCtes.findFromIdCatalogo(idCatalogo);
		} catch (ServiceException e) {
			log.error("Error en find clientes en controller: {}", e.getMessage());
		}
		mv.addObject("clientesList", listClientes);
		mv.setViewName("pages/clientes");
		return mv;
	}

	@RequestMapping(value = "/pages/clientes/estatus/nombre/{catalogo}")
	public ModelAndView findAllClientesFromCatalogoDesc(@PathVariable String catalogo) {
		ModelAndView mv = new ModelAndView();
		List<ClienteDTO> listClientes = new ArrayList<ClienteDTO>();
		try {
			listClientes = serviceCtes.findFromNombreCatalogo(catalogo);
		} catch (ServiceException e) {
			log.error("Error en find clientes en controller: {}", e.getMessage());
		}
		mv.addObject("clientesList", listClientes);
		mv.setViewName("pages/clientes");
		return mv;
	}

}
