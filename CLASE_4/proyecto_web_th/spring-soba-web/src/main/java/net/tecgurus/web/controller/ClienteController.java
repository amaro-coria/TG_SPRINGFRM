package net.tecgurus.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ClienteController {

	private static final Logger log = LoggerFactory.getLogger(ClienteController.class);

	@RequestMapping(value = "/pages/clientes", method = RequestMethod.GET)
	public ModelAndView clientes() {
		log.debug("clientes() is executed");
		ModelAndView model = new ModelAndView();
		model.setViewName("pages/clientes");
		return model;
	}


}
