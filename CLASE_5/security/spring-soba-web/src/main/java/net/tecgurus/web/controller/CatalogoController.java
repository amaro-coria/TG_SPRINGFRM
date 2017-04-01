package net.tecgurus.web.controller;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import net.tecgurus.dto.CatalogoGeneralDTO;
import net.tecgurus.entities.CatalogoGeneral;
import net.tecgurus.persistence.CatalogoDAO;
import net.tecgurus.persistence.PersistenceException;
import net.tecgurus.service.CatalogoService;
import net.tecgurus.service.ServiceException;

@Controller
public class CatalogoController {

	@Autowired
	private CatalogoService service;

	@Autowired
	private CatalogoDAO daoCata;

	private Logger log = LoggerFactory.getLogger(CatalogoController.class);

	@RequestMapping(value = "/pages/catalogo/alta", method = RequestMethod.POST)
	public ModelAndView guardaCatalogo(@ModelAttribute(value = "catalogoGeneral") CatalogoGeneralDTO catalogoGeneral) {
		log.debug("Inicio de metodo de guardado por POST en Catalogo General controller");
		catalogoGeneral.setFchCre(new Date());
		catalogoGeneral.setIdEstCat(1);
		Integer i = null;
		try {
			i = service.create(catalogoGeneral);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (i == null) {
			// TODO
		}
		List<CatalogoGeneralDTO> list = null;
		try {
			list = service.findAll();
		} catch (ServiceException e) {
			// TODO
		}
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", list);
		mv.setViewName("pages/catalogo");
		return mv;
	}

	@RequestMapping(value = "/pages/catalogo/nuevo")
	public ModelAndView altaCatalogo() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("catalogoGeneral", new CatalogoGeneralDTO());
		mv.setViewName("pages/catalogo_nuevo");
		return mv;
	}

	@RequestMapping(value = "/pages/catalogo")
	public ModelAndView listadoHTML() {
		List<CatalogoGeneral> list = daoCata.findAll();
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", list);
		mv.setViewName("pages/catalogo");
		return mv;
	}

	@RequestMapping(value = "/listado")
	public ModelAndView listAll() {
		List<CatalogoGeneralDTO> list = null;
		try {
			list = service.findAll();
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", list);
		mv.setViewName("catalogo");
		return mv;
	}

	@RequestMapping(value = "/test/{numero}")
	public String test(@PathVariable Integer numero) {
		log.debug("Invocacion a metodo test con numero: {}", numero);
		return "catalogo";
	}

	@RequestMapping(value = "/alta/{dscCorta}/{dscCompleta}")
	public ModelAndView alta(@PathVariable(value = "dscCorta") String campo1,
			@PathVariable(value = "dscCompleta") String campo2) {
		CatalogoGeneralDTO cat = new CatalogoGeneralDTO();
		cat.setDscCorCat(campo1);
		cat.setDscComCat(campo2);
		cat.setIdEstCat(1);
		cat.setFchCre(new Date());
		try {
			service.create(cat);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listAll();

	}

}
